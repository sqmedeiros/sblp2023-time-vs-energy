#include <bits/stdc++.h>
using namespace std;
// GCC Optimizations
#pragma GCC optimize("Ofast")
//#pragma GCC target("fma,sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,tune=native")
#pragma GCC optimize("unroll-loops")
// Shortening STL container's member functions' names
#define R(f,t)template<typename...S>inline auto t(S&&...a)->decltype(this->f(forward<S>(a)...)){return this->f(forward<S>(a)...);}
#define alias(f,t) using t = f;
#define alias_t(f, t) template<typename ...T> using t = f<T...>;
#define iterator_aliases R(begin,b);R(end,e);R(rbegin,rb);R(rend,re);R(cbegin,cb);R(cend,ce);R(crbegin,crb);R(crend,cre);
#define unordered_aliases R(find,f);R(count,c);R(emplace,m);R(insert,ins);R(erase,ers);R(clear,cl);
#define ordered_aliases unordered_aliases;R(lower_bound,lb);R(upper_bound,ub);R(equal_range,eqr);
#define capacity_aliases R(empty,mt);R(size,s);
#define begin_alias(n)template<typename...T>struct n##_alias:public n<T...>{using n<T...>::n;
#define begin_tl_alias(n)struct n##_alias:public n{
#define end_alias(n)};
#define end_tl_alias(n)};
begin_alias(vector) iterator_aliases; capacity_aliases; R(push_back, pb); R(pop_back, ppb);
  R(resize, rs); R(front, f); R(back, bk); R(clear, cl); R(emplace, m); R(emplace_back, mb); end_alias(vector);
begin_alias(list) iterator_aliases; capacity_aliases; R(push_back, pb); R(pop_back, ppb);
  R(push_front, pf); R(pop_front, ppf); R(resize, rs); R(front, f); R(back, bk);
  R(clear, cl); R(emplace_front, mf); R(emplace_back, mb); end_alias(list);
begin_alias(set) iterator_aliases; ordered_aliases; capacity_aliases; end_alias(set);
begin_alias(multiset) iterator_aliases; ordered_aliases; capacity_aliases; end_alias(multiset);
begin_alias(unordered_set) iterator_aliases; unordered_aliases; capacity_aliases; end_alias(unordered_set);
begin_alias(unordered_multiset) iterator_aliases; unordered_aliases; capacity_aliases; end_alias(unordered_multiset);
begin_alias(map) iterator_aliases; ordered_aliases; capacity_aliases; end_alias(map);
begin_alias(multimap) iterator_aliases; ordered_aliases; capacity_aliases; end_alias(multimap);
begin_alias(unordered_map) iterator_aliases; unordered_aliases; capacity_aliases; end_alias(unordered_map);
begin_alias(unordered_multimap) iterator_aliases; unordered_aliases; capacity_aliases; end_alias(unordered_multimap);
begin_alias(stack) capacity_aliases; R(top, t); R(push, p); R(pop, pp); R(emplace, m); end_alias(stack);
begin_alias(queue) capacity_aliases; R(front, f); R(back, b); R(push, p); R(emplace, m); R(pop, pp); end_alias(queue);
begin_alias(priority_queue) capacity_aliases; R(top, t); R(push, p); R(emplace, m); R(pop, pp); end_alias(priority_queue);
begin_alias(basic_string)
  basic_string_alias(basic_string<T...> &&s) : basic_string<T...>(s) {}
  capacity_aliases; iterator_aliases; R(length, l); R(shrink_to_fit, stf); R(push_back, pb);
  R(pop_back, ppb); R(insert, ins); R(erase, ers); R(replace, rep); R(substr, ss); R(find, f); R(rfind, rf);
  R(find_first_of, ffo); R(find_last_of, flo); R(find_first_not_of, ffno); R(find_last_not_of, flno);
  R(compare, comp); R(c_str, cs); end_alias(basic_string);
begin_alias(complex); R(imag, x); R(real, y); end_alias(complex);
template<typename T1, typename T2> struct pair_alias : pair<T1, T2> {
  using pair<T1,T2>::pair;
  inline int &x() {return this->first;}
  inline int &y() {return this->second;}
  inline int &f() {return this->first;}
  inline int &s() {return this->second;}
  inline int x() const {return this->first;}
  inline int y() const {return this->second;}
  inline int f() const {return this->first;}
  inline int s() const {return this->second;}
};
#define string basic_string_alias<char>
#define pair pair_alias
#define complex complex_alias
#define list list_alias
#define vector vector_alias
#define set set_alias
#define multiset multiset_alias
#define unordered_set unordered_set_alias
#define unordered_multiset unordered_multiset_alias
#define map map_alias
#define multimap multimap_alias
#define unordered_map unordered_map_alias
#define unordered_multimap unordered_multimap_alias
#define stack stack_alias
#define queue queue_alias
#define priority_queue priority_queue_alias
 
#undef R
// shortening long type names
typedef unsigned int uint; typedef long long ll; typedef unsigned long long ull; typedef long double ld;
typedef pair<int, int> pii; typedef pair<ll, ll> pll; typedef pair<double, double> pdd;
typedef tuple<int, int, int> tiii; typedef tuple<ll, ll, ll> tlll; typedef complex<int> point;
typedef complex<double> fpoint; typedef vector<int> vi; typedef vector<pii> vii; typedef vector<ll> vl;
typedef vector<pll> vll;
// pre-defined constants
const int iinf = 0x3f3f3f3f;
const ll linf = 0x3f3f3f3f3f3f3f3f;
#define nl '\n'
#define nls "\n"
#define cint const int
// ease-of-use functions
inline void cppinput() {ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);}
inline int gc() {return getchar_unlocked();} inline int pc(int c) {return putchar_unlocked(c);}
template<typename T>constexpr inline T lg(T x){return sizeof(T)*8-(sizeof(T)>4?__builtin_clzll(x):__builtin_clz(x))
                                                      -is_signed<T>::value;}
template<typename T> inline void scan(T& x){char _,_n;while((_n=gc())<45);if(_n-45)x=_n;else x=gc();
  for(x-=48;47<(_=gc());x=(x<<3)+(x<<1)+_-48);if(_n<46)x=-x;}
template <typename T, typename ...S>void scan(T& m, S&...s) {scan(m); scan(s...);}
ostream& operator<<(ostream &output, const pii &p) {output << '(' << p.first << "," << p.second << ')';return output;}
ostream& operator<<(ostream &output, const pdd &p) {output << '(' << p.first << "," << p.second << ')';return output;}
template<typename T> constexpr const inline T& _max(const T& x, const T& y) {return x<y?y:x;}
template<typename T> constexpr const inline T& _min(const T& x, const T& y) {return x<y?x:y;}
template<typename T,typename ...S>constexpr const inline T& _max(const T& m, const S&...s){return _max(m,_max(s...));}
template<typename T,typename ...S>constexpr const inline T& _min(const T& m, const S&...s){return _min(m,_min(s...));}
#define max(...) _max(__VA_ARGS__)
#define min(...) _min(__VA_ARGS__)
#define gbt(type, ...) type __VA_ARGS__ ; scan(__VA_ARGS__);
#define gb(...) int __VA_ARGS__ ; scan(__VA_ARGS__);
template<typename T> inline void print(const T& n){T N=n;if(n<0){pc('-');N=-N;}T rev=N,count=0;if(N==0){pc('0');
    return;}while((rev%10)==0){++count;rev/=10;}rev=0;while(N!=0){rev=(rev<<3)+(rev<<1)+N%10;N/=10;}while(rev!=0)
  {pc(rev%10+'0');rev/=10;}while(count)pc('0'),--count;}
template<typename T, typename ...S> inline void print(const T& t, const S&...s){print(t); pc(' '); print(s...);}
// support for variable argument looping macros
#define GET_MACRO(_1,_2,_3,NAME,...) NAME
#define lp_e(e) for(int _=0;_<e;++_)
#define lp_ve(v,e) for(int v=0;v<e;++v)
#define lp_vbe(v,b,e) for(int v=b;v<e;++v)
#define lpe_e(e) for(int _=0;_<=e;++_)
#define lpe_ve(v,e) for(int v=0;v<=e;++v)
#define lpe_vbe(v,b,e) for(int v=b;v<=e;++v)
#define lp(...) GET_MACRO(__VA_ARGS__, lp_vbe, lp_ve, lp_e)(__VA_ARGS__)
#define lpe(...) GET_MACRO(__VA_ARGS__, lpe_vbe, lpe_ve, lpe_e)(__VA_ARGS__)
#define raw_all(v,N) v, v+N
#define it_all(v) v.begin(), v.end()
#define all(...) GET_MACRO(__VA_ARGS__, _, raw_all, it_all)(__VA_ARGS__)
// shortening conditionals
#define elif else if
#define els else
#define whl while
// shortening long STL names
#define rename_t(from, to) template<typename ...Ts> using to = from<Ts...>;
#define R(f,t)template<typename...S>static auto t(S&&...a)->decltype(f(forward<S>(a)...)){return f(forward<S>(a)...);}
struct SC {
  // <algorithm>
  R(all_of, alo);
  R(any_of, ano);
  R(none_of, no);
  R(for_each, fe);
  R(find, f);
  R(find_if, ff);
  R(find_if_not, ffn);
  R(count, c);
  R(count_if, cf);
  R(equal, eq);
  R(is_permutation, ip);
  R(search, sr);
  R(copy, cp);
  R(copy_if, cpf);
  R(copy_backward, cpb);
  R(move, mv);
  R(move_backward, mvb);
  R(swap, sw);
  R(transform, tf);
  R(replace, rp);
  R(replace_if, rpf);
  R(fill, fl);
  R(fill, fln);
  R(generate, gen);
  R(generate_n, genn);
  R(remove, rm);
  R(remove_if, rmf);
  R(unique, q);
  R(rotate, rot);
  R(random_shuffle, rs);
  R(reverse, rv);
  R(shuffle, sh);
  R(sort, s);
  R(stable_sort, ss);
  R(memset, mms);
  R(lower_bound, lb);
  R(upper_bound, ub);
  R(equal_range, eqr);
  R(binary_search, bs);
  R(min_element, mne);
  R(max_element, mxe);
  R(minmax_element, mme);
  R(back_inserter, bi);
  R(distance, d);
  R(getline, gl);
  R(print, p);
  R(next_permutation, np);
  R(prev_permutation, pp);
  // <numeric>
  R(accumulate, acc);
  R(adjacent_difference, ad);
  R(partial_sum, ps);
  R(inner_product, ip);
  // <functional>
  R(bind1st, b1);
  R(bind2nd, b2);
  alias_t(greater, gr);
  alias_t(greater_equal, gre);
  alias_t(less, ls);
  alias_t(less_equal, lse);
  alias_t(minus, mi);
  alias(string, str);
  alias_t(ostream_iterator, oi);
  alias_t(vector, v);
  alias_t(multiset, ms);
  alias_t(unordered_set, us);
  alias_t(unordered_multiset, ums);
  alias_t(unordered_map, um);
  alias_t(priority_queue, pq);
 
};
#undef R
 
cint MAXN = 200000;
pii movies[MAXN];
int main() {
  SC::ms<int> M;
  gb(N, K);
  lp(i, N) {
    scan(movies[i].s(), movies[i].f());
  }
  SC::s(all(movies, N));
  int ans = 1;
  // one guy is watching the movie
  M.ins(movies[0].f());
  lp(i, 1, N) {
    auto it = M.lb(movies[i].s());
    if (it == M.e()) {
      --it;
      M.ers(it);
      M.ins(movies[i].f());
      ++ans;
    } elif (*it == movies[i].s()) {
      M.ers(it);
      M.ins(movies[i].f());
      ++ans;
    } elif (it == M.b()) {
        if (M.s() < K) {
          M.ins(movies[i].f());
          ++ans;
        }
     
    } els {
      if (*it != movies[i].s()) --it;
      M.ers(it);
      M.ins(movies[i].f());
      ++ans;
    }
  }
  print(ans);
}
