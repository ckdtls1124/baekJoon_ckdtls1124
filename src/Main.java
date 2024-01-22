import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader typeIn = new BufferedReader(new InputStreamReader(System.in));


//        테스트 횟수
        int testCnt = Integer.parseInt(typeIn.readLine());


        for(int i=0; i<testCnt; i++){

//            건물의 갯수
            int buildingCnt = Integer.parseInt(typeIn.readLine().split(" ")[0]);

//            건물 간의 건설 수 규칙의 총개수
            int ruleCnt = Integer.parseInt(typeIn.readLine().split(" ")[1]);

            String _constructTime = typeIn.readLine();
            String[] _constructArr = _constructTime.split(" ");

            int result = 0;
            for(int j=0; j<_constructArr.length; j++){

                int first = Integer.parseInt(typeIn.readLine().split(" ")[0]);
                int second = Integer.parseInt(typeIn.readLine().split(" ")[1]);

                int compareVal = Integer.compare(Integer.parseInt(_constructArr[first - 1]), Integer.parseInt(_constructArr[second - 1]));

                if(compareVal >= 0){
                    result = result + Integer.parseInt(_constructArr[first -1]);
                }
                else if(compareVal < 0) {
                    result = result + Integer.parseInt(_constructArr[second -1]);
                }

            }


            System.out.println(result);






        }


    }
}