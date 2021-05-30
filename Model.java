public class Model {

    private Viewer viewer;
    int[][] desktop;
    int indexJ;
    int indexI;
    private boolean init;
    int[][] arrayGoal;
     Levels levels;

    public Model(Viewer viewer) {
        this.viewer = viewer;
       // makeDesktop();
	levels = new Levels(); 
	desktop = levels.nextLevel();  
	desktopInitialization();

    };
        public void move(String direction) {

        if (direction.equals("Left")) {
            moveLeft();
        } else if (direction.equals("Up")) {
            moveUp();
        } else if (direction.equals("Right")) {
            moveRight();
        } else if (direction.equals("Down")) {
            moveDown();
        }
        checkGoal();
        viewer.updateCanvas();
        won();
	//print();


    }

    private void moveLeft() {
        if (desktop[indexI][indexJ - 1] == 3
                && (desktop[indexI][indexJ - 2] == 0
                || desktop[indexI][indexJ - 2] == 4)) {
            desktop[indexI][indexJ - 2] = 3;
            desktop[indexI][indexJ - 1] = 0;
        }
        if (desktop[indexI][indexJ - 1] == 0
                || desktop[indexI][indexJ - 1] == 4) {
            desktop[indexI][indexJ] = 0;
            indexJ = indexJ - 1;
            desktop[indexI][indexJ] = 1;
        }

    }

    private void moveUp() {
        if (desktop[indexI - 1][indexJ] == 3
                && (desktop[indexI - 2][indexJ] == 0
                || desktop[indexI - 2][indexJ] == 4)) {
            desktop[indexI - 2][indexJ] = 3;
            desktop[indexI - 1][indexJ] = 0;
        }
        if (desktop[indexI - 1][indexJ] == 0
                || desktop[indexI - 1][indexJ] == 4) {
            desktop[indexI][indexJ] = 0;
            indexI = indexI - 1;
            desktop[indexI][indexJ] = 1;
        }
    }

    private void moveRight() {
        if (desktop[indexI][indexJ + 1] == 3
                && (desktop[indexI][indexJ + 2] == 0
                || desktop[indexI][indexJ + 2] == 4)) {
            desktop[indexI][indexJ + 2] = 3;
            desktop[indexI][indexJ + 1] = 0;
        }
        if (desktop[indexI][indexJ + 1] == 0
                || desktop[indexI][indexJ + 1] == 4) {
            desktop[indexI][indexJ] = 0;
            indexJ = indexJ + 1;
            desktop[indexI][indexJ] = 1;
        }


    }

    private void moveDown() {
        if (desktop[indexI + 1][indexJ] == 3
                && (desktop[indexI + 2][indexJ] == 0
                || desktop[indexI + 2][indexJ] == 4)) {
            desktop[indexI + 2][indexJ] = 3;
            desktop[indexI + 1][indexJ] = 0;
        }
        if (desktop[indexI + 1][indexJ] == 0
                || desktop[indexI + 1][indexJ] == 4) {
            desktop[indexI][indexJ] = 0;
            indexI = indexI + 1;
            desktop[indexI][indexJ] = 1;
        }
    }

    public boolean getInit() {
        return init;
    }

    private void desktopInitialization() {
        init = false;
        int size = 0;
        int count = 0;
        int countThree = 0;
        int countFour = 0;


        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 1) {
                    count++;
                    indexI = i;
                    indexJ = j;
                }
                if (desktop[i][j] == 4) {                
                    size++;
                    countFour++;
                }
                if (desktop[i][j] == 3) {
                  //  size++;
                    countThree++;
                }

            }

        }
        if (count == 1) {
            init = true;
        }
        if ((countThree != countFour) || ((countThree == 0) & (countFour == 0))) {
            init = false;
        }

        arrayGoal = new int[2][size];

        
        int t = 0;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 4) {
                    arrayGoal[0][t] = i;
                    arrayGoal[1][t] = j;
                    t++;

                }
            }

       	 }
}


/*        private void print() {
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                System.out.print(desktop[i][j] + " ");
            }                 
            System.out.println();

        }
        System.out.println();
        System.out.println("----------------");


    }

*/
    public void checkGoal() {
        for (int j = 0; j < arrayGoal[0].length; j++) {

            int i1 = arrayGoal[0][j];
            int j1 = arrayGoal[1][j];
            if (desktop[i1][j1] == 0) {
               	 desktop[i1][j1] = 4;	
	        System.out.println(desktop[i1][j1]);

            }
        }

    }
     
    public void won() {
        boolean flag = true;
        for (int j = 0; j < arrayGoal[0].length; j++) {
            int x = arrayGoal[0][j];
            int y = arrayGoal[1][j];
            if ( desktop[x][y] != 3) {
                flag = false;
            }

        }
        if (flag) {
	viewer.updateCanvas();		
            javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(), "�� ��������!");
			desktop = levels.nextLevel();
			desktopInitialization();
			viewer.updateCanvas();
	  }
    }
/*    public String openFile(String nameFile) {
        String text = "";
        try {
            FileReader fileReader = new FileReader(nameFile);
            BufferedReader inputStream = new BufferedReader(fileReader);

            String line;
            while ((line = inputStream.readLine()) != null) {
                text += line + "\n";
            }
            inputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return text;
    }

    public void makeDesktop(){
        String textFromFile = openFile("levels/");

        int row = 0;
        for (int i = 0; i < textFromFile.length(); i++) {
            char symbol = textFromFile.charAt(i);
            if (symbol == '\n') {
                row++;

            } else {
                if ('0' <= symbol & '9' >= symbol) {
                }
            }

        }

        desktop = new int[row][];
        int column = 0;
        int indexI = 0;


        for (int i = 0; i < textFromFile.length(); i++) {
            char symbol = textFromFile.charAt(i);
            if (symbol == '\n') {
                desktop[indexI] = new int[column];
                column = 0;
                indexI++;

            } else {
                if ('0' <= symbol & '9' >= symbol) {
                    column++;
                }
            }
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < textFromFile.length(); i++) {
            char symbol = textFromFile.charAt(i);
            if (symbol == '\n'){
                y++;
                x=0;
            }else {
                if ('0' <= symbol & '9' >= symbol) {
                    desktop[y][x] = Integer.parseInt("" + symbol);
                    x++;
                }
            }

        }

    }

 */
}

