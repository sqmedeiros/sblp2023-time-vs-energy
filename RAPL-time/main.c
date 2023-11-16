#include <stdio.h>
#include <time.h>
#include <math.h>
#include <string.h>
#include <sys/time.h>
#include<sys/wait.h>
#include <unistd.h>
#include<error.h>

#include "rapl.h"

#define RUNTIME 1
#define NRUNS 10

typedef struct Time {
	int real;
	int user;
	int sys;
} Time;

void init_time (Time *t) {
	t->real = t->user = t->sys = 0;
}

int get_time_from_line (const char *line) {
	int minute, second, milisecond;
	char tmp[100];
	sscanf(line, "%s %dm%d,%ds", tmp, &minute, &second, &milisecond);
	
	return minute * 60 * 1000 + second * 1000 + milisecond;
}

Time get_time_from_file (const char *file_name, int n) {
	FILE *fp = fopen(file_name, "r");
	char *line = NULL;
	size_t len = 0;
	Time t;
	init_time(&t);
	
	if (fp == NULL) {
		fprintf(stderr, "Error opening file %s", file_name);
		exit(EXIT_FAILURE);
	}
		
	while (getline(&line, &len, fp) != -1) { 
   	if (strncmp(line, "real", 4) == 0) { /* real */
			t.real += get_time_from_line(line);

			/* user */
			getline(&line, &len, fp);
			t.user += get_time_from_line(line);

			/* sys */
			getline(&line, &len, fp); /* sys */
			t.sys += get_time_from_line(line);
   	} 
  }

  fclose(fp);
  if (line)
  	free(line);

  return t;
}

int main (int argc, char **argv) 
{ 
  char commandPre[500]="", commandPos[500]="", test[500]="", language[500]="", path[500]="";
  char command[10000] = "", tmp_output[20] = "rapl_tmp.txt";
  int  core = 0;
  int  i = 0;

#ifdef RUNTIME
  //clock_t begin, end;
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
  int n_test = 0;
  while (input_file != NULL) {
      if (n_test > 0) {
          strcat(command, "  &&  ");
      }
      #ifdef RUNTIME
        strcat(command, "{ time ");
      #endif
      strcat(command, commandPre);
      strcat(command, input_file);
      strcat(command, commandPos);
      strcat(command, " ; } 2>> ");
      strcat(command, tmp_output);
      input_file = strtok(NULL, " ");
      n_test++;
  }

  printf("Command %s\n", command);

  for (i = 0 ; i < NRUNS ; i++) {
       /* Delete previous tmp output */
       remove(tmp_output);

      fprintf(fp,"%s , ", argv[5]);
    
		     #ifdef RUNTIME
		      //begin = clock();
				  //gettimeofday(&tvb,0);
		     #endif
	
	        rapl_before(fp,core);
          //int status = system(command);
          int pid = fork();
          if (pid == -1) {
            error(1, 0, "error in creating the sub-process\n");
          } else if (pid == 0) {
            execl("/usr/bin/bash", "bash", "-c", command, (char *) NULL);
          } else {
           wait(NULL);
          }
          
	        rapl_after(fp,core);

		    #ifdef RUNTIME
			    //end = clock();
			    //time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
			    //gettimeofday(&tva,0);
					//time_spent = (tva.tv_sec-tvb.tv_sec)*1000000 + tva.tv_usec-tvb.tv_usec;
					//time_spent = time_spent / 1000;
					Time t = get_time_from_file(tmp_output, n_test);
				#endif

		#ifdef RUNTIME	
			fprintf(fp," %d, %d, %d\n", t.real, t.user, t.sys);
		#endif	
    }
    
  fclose(fp);
  fflush(stdout);

  return 0;
}



