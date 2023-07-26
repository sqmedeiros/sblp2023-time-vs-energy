#include <iostream>
#include <random>
#include <chrono>
#include <utility>
 
class RandomNumberGenerator {
private:
    std::mt19937 rng;
public:
    RandomNumberGenerator();
    int operator()();
};
 
RandomNumberGenerator::RandomNumberGenerator() : rng(std::chrono::steady_clock::now().time_since_epoch().count()){ }
 
int RandomNumberGenerator::operator()() {
    return int(rng());
}
 
namespace ds {
    template<typename T>
    class BinarySearchTree {
    public:
        class Node {
        protected:
            T key;
            Node *left, *right, *parent;
        public:
            explicit Node(const T &k, Node *p = nullptr, Node *l = nullptr, Node *r = nullptr) : key(k), left(l),
                                                                                                 right(r), parent(p) {}
 
            virtual Node *get_left() {
                return left;
            }
 
            virtual Node *get_right() {
                return right;
            }
 
            virtual Node *get_parent() {
                return parent;
            }
 
            T get_key() {
                return key;
            }
 
            friend class BinarySearchTree;
        };
 
 
        virtual Node *find(const T &x) = 0;
 
        virtual Node *insert(const T &x) = 0;
 
        virtual bool erase(const T &x) = 0;
 
        virtual bool contains(const T &x) = 0;
 
        static Node *bt_search(Node *current, const T &x) {
            if (current == nullptr) {
                return nullptr;
            }
            if (current->key == x) {
                return current;
            } else if (current->key < x) {
                return bt_search(current->right, x);
            } else if (current->key > x) {
                return bt_search(current->left, x);
            }
        }
    };
        template<typename T, typename RNG = RandomNumberGenerator>
        class CartesianTree: public BinarySearchTree<T> {
        public:
            class Node;
        private:
            RNG rng;
            std::size_t sz;
            Node* root;
 
            static std::pair<Node*, Node*> split(Node* c, const T& x) {
                if(c == nullptr) {
                    return {nullptr, nullptr};
                }
                if(c->key < x) {
                    auto [ls, rs] = split(c->get_right(), x);
                    c->right = ls;
                    if(c->get_right() != nullptr) {
                        c->get_right()->parent = c;
                    }
                    return {c, rs};
                }
                auto [ls, rs] = split(c->get_left(), x);
                c->left = rs;
                if(c->get_left() != nullptr) {
                    c->get_left()->parent = c;
                }
                return {ls, c};
            }
 
            static Node* merge(Node* l, Node* r) {
                if(l == nullptr) {
                    return r;
                }
                if(r == nullptr) {
                    return l;
                }
 
                if(l->prior > r->prior) {
                    l->right = merge(l->get_right(), r);
                    if(l->get_right() != nullptr) {
                        l->get_right()->parent = l;
                    }
                    return l;
                }
                r->left = merge(l, r->get_left());
                if(l->get_left() != nullptr) {
                    l->get_left()->parent = l;
                }
                return r;
            }
 
            static Node* find_leftmost(Node* current) {
                if(current->left == nullptr) {
                    return current;
                }
                return find_leftmost(current->get_left());
            }
 
        public:
            class Node : public BinarySearchTree<T>::Node {
            private:
                int prior;
            public:
                explicit Node(RNG& generator, const T& k, Node* p = nullptr, Node* l = nullptr, Node* r = nullptr) : BinarySearchTree<T>::Node(k, p, l, r) {
                    prior = generator();
                }
                Node* get_left() {
                    return dynamic_cast<Node*>(this->left);
                }
 
                Node* get_right() {
                    return dynamic_cast<Node*>(this->right);
                }
 
                Node* get_parent() {
                    return dynamic_cast<Node*>(this->parent);
                }
                friend class CartesianTree;
            };
 
            CartesianTree() {
                sz = 0;
                root = nullptr;
            }
 
            Node* find(const T& x) {
                return dynamic_cast<Node*>(BinarySearchTree<T>::bt_search(root, x));
            }
 
            Node* insert(const T& x) {
                if(contains(x)) {
                    return nullptr;
                }
                auto new_node = new Node(rng, x);
                auto [l, r] = split(root, x);
                root = merge(merge(l, new_node), r);
                sz += 1;
                return new_node;
            }
 
            bool erase(const T& x) {
                if(!contains(x)) {
                    return false;
                }
                auto [l, r] = split(root, x);
                auto lft = find_leftmost(r);
                if(lft->parent == nullptr) {
                    root = merge(l, lft->get_right());
                }
                else {
                    lft->get_parent()->left = nullptr;
                    root = merge(l, r);
                }
                delete lft;
                return true;
            }
 
            bool contains(const T& x) {
                return find(x) != nullptr;
            }
 
            bool empty() {
                return sz == 0;
            }
 
            std::size_t size() {
                return sz;
            }
    };
 
} // ds
 
 
int main() {
    int n;
    std::cin >> n;
    ds::CartesianTree<int> a;
 
    for(int i = 0; i < n; i++) {
        int num;
        std::cin >> num;
        a.insert(num);
    }
 
    std::cout << a.size() << std::endl;
 
 
    return 0;
}