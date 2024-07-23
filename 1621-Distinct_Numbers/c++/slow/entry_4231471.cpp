#include <bits/stdc++.h>
 
using namespace std;
 
typedef long long ll;
 
mt19937 rng(time(nullptr));
 
struct treap {
    ll val, pri, siz;
    treap *left, *right;
    treap (ll v) : val(v), pri(rng()), siz(1), left(NULL), right(NULL) {};
};
 
treap *root;
 
ll siz(treap *t){
    if (!t)return 0;
    return (t->siz);
}
 
void upd_siz(treap *t){
    (t->siz) = 1+siz(t->left)+siz(t->right);
}
 
treap *merge(treap *l, treap *r){
    if (!l)return r;
    if (!r)return l;
    if (l->pri > r->pri){
        (l->right) = merge(l->right, r);
        upd_siz(l);
        return l;
    }
    else {
        (r->left) = merge(l, r->left);
        upd_siz(r);
        return r;
    }
}
 
pair<treap*, treap*> split(treap *t, ll v){
    if (!t)return {NULL, NULL};
    if (t->val >= v){
        pair<treap*, treap*> p = split(t->left, v);
        (t->left) = p.second;
        upd_siz(t);
        return {p.first, t};
    }
    else {
        pair<treap*, treap*> p = split(t->right, v);
        (t->right) = p.first;
        upd_siz(t);
        return {t, p.second};
    }
}
 
void push(ll v){
    pair<treap*, treap*> p = split(root, v);
    p.first = merge(p.first, new treap(v));
    root = merge(p.first, p.second);
}
 
void remove(ll v){
    pair<treap*, treap*> p = split(root, v);
    pair<treap*, treap*> r = split(p.second, v+1);
    root = merge(p.first, r.second);
}
 
ll count(ll v){
    pair<treap*, treap*> p = split(root, v);
    pair<treap*, treap*> r = split(p.second, v+1);
    ll k = siz(r.first);
    p.second = merge(r.first, r.second);
    root = merge(p.first, p.second);
    return k;
}
 
ll find_by_order(treap *t, ll v, ll add){
    if (!t)return -1;
    if (siz(t->left)+add == v)return (t->val);
    else if (siz(t->left)+add > v)return find_by_order(t->left, v, add);
    else return find_by_order(t->right, v, add+siz(t->left)+1);
}
 
int main(){
    root = NULL;
    ll n; cin >> n;
    ll v[n];
    for (int i = 0; i < n; i++){
        cin >> v[i];
        push(v[i]);
    }
    int r = 0;
    for (int i = 0; i < n; i++){
        if (count(v[i])){
            r++;
            remove(v[i]);
        }
    }
    cout << r;
}