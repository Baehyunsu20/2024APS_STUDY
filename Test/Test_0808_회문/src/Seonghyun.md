import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
        String [][] arr = new String [8][8];													// String타입의 8x8배열

		for(int test_case = 1; test_case <= 10; test_case++)
		{
		int sum = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = sc.next();																	// 배열 입력
                }
            }
            
              for(int i = 0; i < 8; i++) {
                  for (int j = 0; j < 8; j++) {
		            if (arr[i][j+1] == arr[i][j])  {        
            			if ( arr[i][j+3] == arr[i][j]) {
                            if ( arr[i][j+5] == arr[i][j]) {
                                if ( arr[i][j+7] == arr[i][j]) {
                			sum ++;																				// 홀수 길이의 행 카운트... 인줄 알았으나 누락된 조건 존재
                                }
                            }
                        }
                    }
                  }
              }
            
            for(int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (arr[i][j+2] == arr[i][j])  {        
                        if ( arr[i][j+4] == arr[i][j]) {
                            if (arr[i][j+6] == arr[i][j])  {
                    		sum ++;	
                            }
                        }
                    }
                }
            }
            
            for(int j = 0; j < 8; j++) {
                  for (int i = 0; i < 8; i++) {
                      if (arr[i+1][j] == arr[i][j])  {        
            			if ( arr[i+3][j] == arr[i][j]) {
                            if ( arr[i+5][j] == arr[i][j]) {
                                if ( arr[i+7][j] == arr[i][j]) {
                			sum ++;
                                }
                            }
                        }
                    }
                  }
              }
            
            for(int j = 0; j < 8; j++) {
                for (int i = 0; i < 8; i++) {
                    if ( arr[i+2][j] == arr[i][j]) {
                        if ( arr[i+4][j] == arr[i][j]) {
                            if ( arr[i+6][j] == arr[i][j]) {
                    		sum ++;																					// 짝수 길이의 열 카운트..
                            }
                        }
                    }
                }
            }
           	
            //
            for(int i = 0; i < 8; i++) {
                  for (int j = 0; j < 8; j++) {
		            if (arr[i][j+1] == arr[i][j])  {        
            			if ( arr[i][j+3] == arr[i][j]) {
                            if ( arr[i][j+5] == arr[i][j]) {
                			sum ++;														
                            }
                        }
                    }
                  }
              }
            
            for(int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (arr[i][j+2] == arr[i][j])  {        
                        if ( arr[i][j+4] == arr[i][j]) {
                    		sum ++;	
                        }
                    }
                }
            }
            
            for(int j = 0; j < 8; j++) {
                  for (int i = 0; i < 8; i++) {
                      if (arr[i+1][j] == arr[i][j])  {        
            			if ( arr[i+3][j] == arr[i][j]) {
                            if ( arr[i+5][j] == arr[i][j]) {
                			sum ++;
                            }
                        }
                    }
                  }
              }
            
            for(int j = 0; j < 8; j++) {
                for (int i = 0; i < 8; i++) {
                    if ( arr[i+2][j] == arr[i][j]) {
                        if ( arr[i+4][j] == arr[i][j]) {
                    		sum ++;												
                        }
                    }
                }
            }
            //
                        for(int i = 0; i < 8; i++) {
                  for (int j = 0; j < 8; j++) {
		            if (arr[i][j+1] == arr[i][j])  {        
            			if ( arr[i][j+3] == arr[i][j]) {
                			sum ++;														
                        }
                    }
                  }
              }
            
            for(int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (arr[i][j+2] == arr[i][j])  {        
                    		sum ++;	
                    }
                }
            }
            
            for(int j = 0; j < 8; j++) {
                  for (int i = 0; i < 8; i++) {
                      if (arr[i+1][j] == arr[i][j])  {        
            			if ( arr[i+3][j] == arr[i][j]) {
                			sum ++;
                        }
                    }
                  }
              }
            
            for(int j = 0; j < 8; j++) {
                for (int i = 0; i < 8; i++) {
                    if ( arr[i+2][j] == arr[i][j]) {
                    		sum ++;												
                    }
                }
            }
            System.out.println("#" + test_case + " " + sum);
                    
                    
              

		}
	}
}