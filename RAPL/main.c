

#include <stdio.h>
#include <time.h>
#include <math.h>
#include <string.h>
#include <sys/time.h>
#include "rapl.h"

#define RUNTIME 1
#define NRUNS 10


int main (int argc, char **argv) 
{ 
  char commandPre[500]="", commandPos[500]="", test[500]="", language[500]="", path[500]="";
  char command[10000] = "";
  int  core = 0;
  int  i = 0;

#ifdef RUNTIME
  //clock_t begin, end;
  double time_spent, total_time;
  struct timeval tvb,tva;
#endif
  
  FILE * fp;

  //Run command
  //strcpy(commandPre, "./" );
  strcpy(commandPre, argv[1]);
  strcpy(commandPos, argv[3]);
  //Language name
  strcpy(path,"./");
  //printf("Path %s\n", path);

  strcpy(language,argv[4]);
  strcat(language,".csv");
  strcat(path,language);
  //Test name
  strcpy(test,argv[2]);

  fp = fopen(path,"a");

  rapl_init(core);

  //fprintf(fp,"Package , CPU , GPU , DRAM? , Time (sec) \n");
  
  char *input_file;
  input_file = strtok(test, " ");
  int j = 0;
  while (input_file != NULL) {
      if (j > 0) {
          strcat(command, "  &&  ");
      }
      strcat(command, commandPre);
      strcat(command, input_file);
      strcat(command, commandPos);
      input_file = strtok(NULL, " ");
      j++;
  }

  printf("Command %s\n", command);

  for (i = 0 ; i < NRUNS ; i++) {
      fprintf(fp,"%s , ", argv[5]);
      total_time = 0;
    
		     #ifdef RUNTIME
		      //begin = clock();
				  gettimeofday(&tvb,0);
		     #endif
	
	        rapl_before(fp,core);
          system(command);
	        rapl_after(fp,core);

		    #ifdef RUNTIME
			    //end = clock();
			    //time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
			    gettimeofday(&tva,0);
					time_spent = (tva.tv_sec-tvb.tv_sec)*1000000 + tva.tv_usec-tvb.tv_usec;
					time_spent = time_spent / 1000;
          total_time += time_spent;
				#endif

		#ifdef RUNTIME	
			fprintf(fp," %G \n", total_time);
		#endif	
    }
    
  fclose(fp);
  fflush(stdout);

  return 0;
}



