/*****************************
/     Author : @sirearsh     /
*****************************/
#include <stdio.h>
#include <algorithm>
 
int t, i;
char acc = '.', out[31];
 
int getInt () {
  t = 0;
  while (acc < '0' || acc > '9') acc = getchar_unlocked();
  while (acc >= '0' && acc <= '9') t = ((t * 10) + (int)(acc - '0')), acc = getchar_unlocked();
  return t;
}
 
void putInt (int num) {
  i = -1;
  while (num) out[++i] = (char)(num % 10 + '0'), num /= 10;
  while (i > -1) putchar_unlocked(out[i--]);
}
 
struct Val {
  int val;
  int id;
  Val (int f = 1, int s = 1) : val(f), id(s) {}
  bool operator< (const Val other) {
    return val < other.val;
  }
};
 
const char imp[] = {'I','M','P','O','S','S','I','B','L','E','\0'};
 
int main () {
  int n = getInt(), tar = getInt();
  Val v[n];
  for (int i = 1; i <= n; ++i) {
    v[i-1].val = getInt();
    v[i-1].id = i;
  }
  std::sort(v,v+n);
  int i = 0, j = n - 1;
  while (i < j) {
    if (v[i].val + v[j].val < tar) ++i;
    else if (v[i].val + v[j].val > tar) --j;
    else {
      putInt(v[i].id);
      putchar_unlocked(' ');
      putInt(v[j].id);
      return 0;
    }
  }
  printf("%s",imp);
	return 0;
}
 
/* Hope it helped you.
                _  _         _    _         _      _ _ _
               |_)|_  /\ /` |_   / \|\ |   |_  /\ |_) | |_|
               |  |_ /""\\_,|_   \_/| \|   |_ /""\| \ | | |
     .-------------------------------------------------------------.
     |    _     .-.                                                |
     |   | `.  /  | ,--.                                .          |
    __   \  |  |_/ /   /                             _.'|          |
 .'   `'. \ /,-'';,'-'`         '.                ,'`   ',    ,    |
  \      \.;'   / |`\,.--.        \             ,'      '|   /|    |
   `-._.-;/    | ,'/\ `.  \        |    .,._ .'          |_,' |,   |
,'```'-.,'     \/ /  \  `-'        .-'`     `'.     _,---'     |   |
`.._____/         ;  |             |`.  o      \ .-'           |   |
    ,-';   /`.    |  /             | |         ,'              |   |
  ,'   /  /  |    '.'             .' ;        /                |   |
 /   ,'| ;   |.-.            _    /  /       .'                '   |
'--'`| | |  /   /.'`.       | `. ;__ .       |                /    |
     | | | /   / |  | .-.   \  | /\_)|       \               '     |
    _|._\|/--'`  |  ' |  \   `.|'    |        `.           ,'\     |
  .'    /`;      | /   \__'_,;-.     :          '-..__.,.-'   `.   |
 /    ,' /\\     |/    _,-|\  \ `.   '                          `'-..__
 '--'`   | \`'-._;_.,-'   | \  '-'    '                                )
     |   |  ;       |\    `._)         \                  ,-'`.       /
     |   ;  |       | \                 `.              ,'    |     ,'
     |    \_/       |  ;                  `-.         ,'      |   ,'
     |              \  |                     `''--''`          `'` |
     |               `-'                                        mx |
     '-------------------------------------------------------------'   - Art by myflix
*/