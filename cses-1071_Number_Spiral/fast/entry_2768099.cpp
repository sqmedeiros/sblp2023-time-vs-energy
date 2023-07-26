#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
 
 
//#pragma GCC optimize("Ofast")
//#pragma GCC target("fma,sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,tune=native")
//#pragma GCC optimize("unroll-loops")
 
 
// https://cses.fi/problemset/task/1071
 
char buffer[100000 * (11*2+2)];
char * pos = buffer;
 
 
#define ULONG_DIGITS 18
 
char output_buffer[100000 * (ULONG_DIGITS+1)];
char * out_pos = output_buffer;
 
#ifdef CPP
inline
#endif
unsigned int my_read_int(void) {
	unsigned int res = 0;
 
	while (!(*pos >= '0' && *pos <= '9' )) {
		pos++;
	}
 
	while (*pos >= '0' && *pos <= '9' ) {
 
		res = (res << 3) + (res << 1) + *pos - '0';
 
		//res = res * 10 + *pos - '0';
		pos++;
	}
 
	return res;
}
 
 
int append_ul(unsigned long i) {
 
	char buffer[32];
 
	char * start = buffer + ULONG_DIGITS+1; //out_pos;
 
	char * p = start;
 
	do {
		*--p = '0' + (i % 10);
		i /= 10;
	} while (i != 0);
 
//    while (start != p) {
//    	*start++ = ' ';
//    }
 
	//printf("start - p = %d\n", start - p);
    memcpy(out_pos, p, start - p);
 
 
    out_pos += start - p;
 
    *out_pos++ = '\n';
    //*out_pos = 0;
 
    return start - p + 1;
}
 
 
 
//#define is_odd(a) ((a & 1) == 1)
//#define is_even(a) ((a & 1) == 0)
 
 
#ifdef CPP
inline
#endif
unsigned long calc_func(unsigned int _x, unsigned int _y) {
	unsigned long x = _x;
	unsigned long y = _y;
 
	unsigned long t;
	unsigned int b = 1;
 
	if (x > y) {
		t = x;
		x = y;
		y = t;
		b = 0;
	}
 
	if ((y & 1) == b) // odd?
		return x + (y-1) * (y-1);
	else
		return y*y - x + 1;
 
	return 0;
}
 
 
int main() {
 
 
//	append_ul(100000000UL);
//
//	write(1, output_buffer, out_pos - output_buffer );
//	return 0;
 
 
	unsigned int x,y;
 
	int res;
	char * buf = buffer;
 
	while ((res = read(0, buf, sizeof(buffer) - (buf - buffer))) > 0) {
		buf += res;
	}
 
	int number_of_tests;
 
	number_of_tests = my_read_int();
 
	for (int i = 0; i < number_of_tests; i++) {
		x = my_read_int();
		y = my_read_int();
 
		res = append_ul(calc_func(y,x));
		//res = sprintf(out_pos,"%lu\n",calc_func(y,x));
 
		//out_pos += res;
	}
 
	res = write(1, output_buffer, out_pos - output_buffer );
 
	return 0;
}