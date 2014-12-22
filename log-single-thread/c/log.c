
#include <stdio.h>
#include <math.h>

double logs[1000000000];

main() {
    unsigned st = (unsigned)time(NULL);
    
      
	int i;
	for(i = 0; i < 1000000000; i++) {
		logs[i] = log(i + 1);
	}

	printf("Exec time: %d", ((unsigned)time(NULL) - st));

}
