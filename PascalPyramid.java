import java.util.ArrayList;

public class PascalPyramid {

    PascalPyramid(int levelsNumber){
        createPyramid(levelsNumber);
    }

    public void createPyramid(int levelsNumber) {

        ArrayList<Integer> evenLevelsNumbers = new ArrayList<Integer>();
        ArrayList<Integer> oddLevelsNumbers = new ArrayList<Integer>();

        String tab = createTab(levelsNumber);
        System.out.println(tab+"1");

        int y,z;
        //Creating second level (1 1)
        evenLevelsNumbers.add(1);
        evenLevelsNumbers.add(1);

        //Starting from a second level of pyramid
        for(int i = 1;i<levelsNumber;i++) {
            tab = createTab(levelsNumber-i);

            System.out.print(tab);


            if((i+1)%2==0) {
                for(Integer x : evenLevelsNumbers) {
                    System.out.print(x+" ");
                }
                //Creating next odd level (1 + sums + 1)
                oddLevelsNumbers.add(1);
                for(int j = 0;j<evenLevelsNumbers.size()-1;j++) {
                    y = evenLevelsNumbers.get(j);
                    z = evenLevelsNumbers.get(j+1);
                    oddLevelsNumbers.add((y+z));
                }
                oddLevelsNumbers.add(1);
                evenLevelsNumbers.clear();
            }

            else {
                for(Integer x : oddLevelsNumbers) {
                    System.out.print(x+" ");
                }
                //Creating next even level (1 + sums + 1)
                evenLevelsNumbers.add(1);
                for(int j = 0;j<oddLevelsNumbers.size()-1;j++) {
                    y = oddLevelsNumbers.get(j);
                    z = oddLevelsNumbers.get(j+1);
                    evenLevelsNumbers.add((y+z));
                }
                evenLevelsNumbers.add(1);
                oddLevelsNumbers.clear();
            }

            System.out.print("\n");

            //String numbers = (i+1)+" ";

            //System.out.println(tab+numbers.repeat(i+1));
        }

    }
    public String createTab(int levelsNumber) {
        return " ".repeat(levelsNumber-1);
    }
}
