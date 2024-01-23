import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader typeIn = new BufferedReader(new InputStreamReader(System.in));


//        테스트 횟수
        int testCnt = Integer.parseInt(typeIn.readLine());


        int result = 0;
        for (int i = 0; i < testCnt; i++) {

            String buildingRule = typeIn.readLine();
//            건물의 갯수
            int buildingCnt = Integer.parseInt(buildingRule.split(" ")[0]);

//            건물 간의 건설 수 규칙의 총개수
            int ruleCnt = Integer.parseInt(buildingRule.split(" ")[1]);

            int[] _constructArr = new int[buildingCnt];

            String _construct = typeIn.readLine();
            for (int k = 0; k < buildingCnt; k++) {
                _constructArr[k] = Integer.parseInt(_construct.split(" ")[k]);
            }


            List<Integer> firstList = new ArrayList<>();
            List<Integer> secondList = new ArrayList<>();

            for (int j = 0; j < ruleCnt; j++) {
                String order = typeIn.readLine();

                int first = Integer.parseInt(order.split(" ")[0]);
                int second = Integer.parseInt(order.split(" ")[1]);

                firstList.add(first);
                secondList.add(second);
            }

            int winNum = Integer.parseInt(typeIn.readLine());

            for(int k=0; k<firstList.size(); k++){

                Integer firstIdx = firstList.get(k);
                Integer firstIdxN = firstList.get(k + 1);
                Integer secondIdx = secondList.get(k);

                if(firstIdx.equals(winNum) || secondIdx.equals(winNum)){
                    break;
                }

                /*if(firstIdx.equals(firstIdxN)){

                    result += result + _constructArr[firstIdx - 1];

                    int compare = Integer.compare(_constructArr[firstIdx - 1], _constructArr[firstIdxN]);

                    if(compare >= 0){
                        result += result + _constructArr[firstIdx - 1];
                    } else {
                        result += result + _constructArr[firstIdx];
                    }

                } else {

                    int compare = Integer.compare(_constructArr[firstIdx - 1], _constructArr[secondIdx - 1]);

                    if(compare >= 0){
                        result += result + _constructArr[firstIdx - 1];
                    } else {
                        result += result + _constructArr[secondIdx - 1];
                    }

                }*/


            }

            System.out.println(result);
        }


    }
}