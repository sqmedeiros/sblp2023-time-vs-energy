#include<bits/stdc++.h>
using namespace std;
long long int contNumDiferentes = 1;
bool numeroIguales = 0;
int numRecursiones;
 
void RQuickSort(long long int arr[],long long int l,long long int h){
    //cout<<endl;
    //cout<<"Recursión #"<<numRecursiones<<endl;
    numRecursiones++;
    //cout<<"indice inferior de la partición a ordenar: "<<l<<endl;
    //cout<<"indice superior de la partición a ordenar: "<<h<<endl;
    int aux = 0;
    if(l >= h){
        return;
    }
    long long int pivote = l + rand() % (h-l);
    //cout<<"Pivote para la partición: "<<pivote<<endl;
    swap(arr[l],arr[pivote]);
    long long int storeIndex = l+1;
    for(long long int i = l+1 ; i<=h ; i++){
        if(arr[i] == arr[l]){
                aux++;
        }
        if(arr[i]<arr[l]){
            swap(arr[i],arr[storeIndex]);
            storeIndex++;
        }
    }
    swap(arr[l],arr[storeIndex-1]);
    if(aux != h-l){
        if(storeIndex-l>2){
            RQuickSort(arr,l,storeIndex-2);
        }
        if(storeIndex<h){
            RQuickSort(arr,storeIndex,h);
        }
    }
}
 
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    long long int n;
    cin>>n;
    long long int* arr = new long long int[n];
    for(long long int i = 0; i<n ; i++){
        cin>>arr[i];
    }
    //cout<<"Generando el arreglo"<<endl;
    //for(long long int i = 0; i<n ; i++){
    //    arr[i] = 1;
    //}
    //arr[n-1] = 2;
    //cout<<"termino de generar el arreglo"<<endl;
    //cout<<"Empieza a hacer el quicksort"<<endl;
    RQuickSort(arr,0,n-1);
    //cout<<"Termino de hacer el quick sort"<<endl;
    long long int aux = arr[0];
    for(long long int k = 1; k<n ;k++){
        if(aux != arr[k]){
            contNumDiferentes++;
            aux = arr[k];
        }
    }
    //for(int k = 0; k<n ; k++){
    //    cout<<arr[k]<<" ";
    //}
    //cout<<endl;
    cout<<contNumDiferentes;
    delete[] arr;
}