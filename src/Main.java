import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader scan;
    /*public static int testRound;
    public static int[] startEndPoint = new int[4];
    public static int planetCount;
    public static List<int[]> planetInfos = new ArrayList<>();
    public static List<Integer> startXDisList = new ArrayList<>();
    public static List<Integer> startYDisList = new ArrayList<>();
    public static List<Integer> endXDisList = new ArrayList<>();
    public static List<Integer> endYDisList = new ArrayList<>();
    public static List<Integer> radiusList = new ArrayList<>();
    public static int startOuterCircleCnt;
    public static int endOuterCircleCnt;*/


    static int convertStringToInt(String valueString) throws NumberFormatException {
        return Integer.parseInt(valueString);
    }

    static boolean calDistance(int x, int y, int xCen, int yCen, int r) {

        boolean result = false;

        result = Math.sqrt(Math.pow(x - xCen, 2) + Math.pow(y - yCen, 2)) < r;

        return result;
    }

    //        테스트 횟수
    public static void main(String[] args) throws IOException {

        scan = new BufferedReader(new InputStreamReader(System.in));

        int length = convertStringToInt(scan.readLine());

        for (int j = 0; j < length; j++) {
//        출발, 도착 위치 입력 받기
            String startEnd = scan.readLine();

            int x_start = convertStringToInt(startEnd.split(" ")[0]);
            int y_start = convertStringToInt(startEnd.split(" ")[1]);
            int x_end = convertStringToInt(startEnd.split(" ")[2]);
            int y_end = convertStringToInt(startEnd.split(" ")[3]);


            int count = convertStringToInt(scan.readLine());


            int inOutCount = 0;
            for (int i = 0; i < count; i++) {


                String circle = scan.readLine();
                int x_center = convertStringToInt(circle.split(" ")[0]);
                int y_center = convertStringToInt(circle.split(" ")[1]);
                int radius = convertStringToInt(circle.split(" ")[2]);

                boolean startResult = calDistance(x_start, y_start, x_center, y_center, radius);
                boolean endResult = calDistance(x_end, y_end, x_center, y_center, radius);

                if (!(startResult && endResult) && (startResult || endResult))
                    inOutCount++;
            }
            System.out.println(inOutCount);
        }


    }

//    20240120_ckdtls1124

//        testRound = convertStringToInt();
//        for(int tR=0;tR<testRound;tR++) {
////        출발점, 도착점
//            System.out.print("Type in start point and target point with blanks :");
//            StringTokenizer scanWblanks = new StringTokenizer(scan.readLine());
//            int count = scanWblanks.countTokens();
//            for (int i = 0; i < count; i++) {
//                String _token = scanWblanks.nextToken();
//                startEndPoint[i] = convertStringToInt(_token);
//            }
//
//
////        행성 계의 개수
//            System.out.print("Type in planet count :");
//            planetCount = convertStringToInt(scan.readLine());
//
////        행성계의 개수에 따라서 각 행성의 중점과 반지름 입력 횟수
//            for (int pC = 0; pC < planetCount; pC++) {
//
//                int[] eachPlaneInfo = new int[3];
////                행성의 중점, 반지름 입력
//                System.out.print("Type in planet's center and radius :");
//                StringTokenizer planetInfo = new StringTokenizer(scan.readLine());
//
//                for(int i=0 ; i<eachPlaneInfo.length ;i++){
//                    eachPlaneInfo[i] = convertStringToInt(planetInfo.nextToken());
//                    planetInfos.add(eachPlaneInfo);
//                }
//
////                행성별 반지름 저장
//                radiusList.add(eachPlaneInfo[2]);
//
//
//            }
//
//            calDistanceStartToCenter();
//            calDistanceEndToCenter();
//            compare();
//        }


}
    /*static void calDistanceStartToCenter(){

        int startX = startEndPoint[0];
        int startY = startEndPoint[1];
        for(int i=0; i<planetInfos.size(); i++){
            int[] eachPlaneInfo = planetInfos.get(i);
            int planetX = eachPlaneInfo[0];
            int planetY = eachPlaneInfo[1];

            int xDistance = 0;
            int yDistance = 0;
            if((startX >= 0 && planetX >= 0) || (startX <= 0 && planetX <= 0))
            {
                xDistance = Math.abs(startX - planetX);
            }
            else if ((startX > 0 && planetX <0) || (startX < 0 && planetX > 0))
            {
                xDistance = Math.abs(startX) + Math.abs(planetX);
            }

            if((startY >= 0 && planetY >= 0) || (startY <= 0 && planetY <= 0))
            {
                yDistance = Math.abs(startY - planetY);
            }
            else if ((startY > 0 && planetY <0) || (startY < 0 && planetY > 0))
            {
                yDistance = Math.abs(startY) + Math.abs(planetY);
            }

            startXDisList.add(xDistance);
            startYDisList.add(yDistance);
        }
    }

    static void calDistanceEndToCenter(){

        int endX = startEndPoint[2];
        int endY = startEndPoint[3];

        for(int i=0; i<planetInfos.size(); i++){
            int[] eachPlaneInfo = planetInfos.get(i);
            int planetX = eachPlaneInfo[0];
            int planetY = eachPlaneInfo[1];

            int xDistance = 0;
            int yDistance = 0;
            if((endX >= 0 && planetX >= 0) || (endX <= 0 && planetX <= 0))
            {
                xDistance = Math.abs(endX - planetX);
            }
            else if ((endX > 0 && planetX <0) || (endX < 0 && planetX > 0))
            {
                xDistance = Math.abs(endX) + Math.abs(planetX);
            }

            if((endY >= 0 && planetY >= 0) || (endY <= 0 && planetY <= 0))
            {
                yDistance = Math.abs(endY - planetY);
            }
            else if ((endY > 0 && planetY <0) || (endY < 0 && planetY > 0))
            {
                yDistance = Math.abs(endY) + Math.abs(planetY);
            }

            endXDisList.add(xDistance);
            endYDisList.add(yDistance);
        }
    }



    static void compare(){

        startOuterCircleCnt = 0;
        endOuterCircleCnt = 0;

        for(int i=0; i<radiusList.size(); i++){
            int radius = radiusList.get(i);

//        출발점과 반지름 비교
            int starX = startXDisList.get(i);
            int starY = startYDisList.get(i);

//        도착점과 반지름 비교
            int endX = endXDisList.get(i);
            int endY = endYDisList.get(i);


            if(radius*radius > (endX*endX + endY*endY)){
                endOuterCircleCnt++;
            }

            if(radius*radius > (starX*starX + starY*starY)){
                startOuterCircleCnt++;
            }



        }


        System.out.println("최소 경우는 총 "+(startOuterCircleCnt + endOuterCircleCnt)+"회 입니다.");

    }*/
