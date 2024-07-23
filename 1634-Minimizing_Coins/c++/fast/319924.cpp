#include <bits/stdc++.h>
using namespace std;
 
 
int main(){
  int nc,tar; scanf("%d%d",&nc,&tar);
//fprintf(stderr,"n=%d tar=%d\n",n,tar);
  vector<int> coin(nc);
  int tn=0;
  for(int i=0;i<nc;i++){
    int t;scanf("%d",&t);
    if(t>tar){continue;}
    if(t==tar){tn=-1;break;}
    coin[tn++]=t;
  }
  if(tn<0){
    printf("1\n");
    return 0;
  }
  nc=tn;
  sort(coin.begin(),coin.begin()+nc);
  auto it=unique(coin.begin(),coin.begin()+nc);
  nc=int(it-coin.begin());
 
//fprintf(stderr,"n=%d\n",n);
//fprintf(stderr,"max coin:%d\n",coin[n-1]);
 
  if(tar<coin[0]){
//fprintf(stderr,"*\n");
    printf("-1\n");
    return 0;
  }
  reverse(coin.begin(),coin.begin()+nc);
 
  vector<int> arr(tar+1,-1);
  arr[0]=0;
  for(int i=0;i<nc;i++){
    arr[coin[i]]=1; //maxcoin can be larger...
  }
 
  for(int i=0;i<nc;i++){
    if(arr[tar]>-1){break;}
    int c=coin[i],j=0;
//fprintf(stderr,"%d\n",c);    
    while(j+c<=tar){
      if(arr[j]>-1){
        if(arr[j+c]>-1){
          arr[j+c]=min(1+arr[j],arr[j+c]);
        }else{
          arr[j+c]=1+arr[j];
        }
      }
      j+=1;
    }
  }
 
  printf("%d\n",arr[tar]);
 
	return 0;
}