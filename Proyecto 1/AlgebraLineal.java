import java.util.Scanner;

public class AlgebraLineal
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int matriz[][] = new int[3][3];
        System.out.print("a: ");
        matriz[0][0] = sc.nextInt();
        System.out.print("b: ");
        matriz[0][1] = sc.nextInt();
 		System.out.print("c: ");
        matriz[0][2] = sc.nextInt();
        System.out.print("d: ");
        matriz[1][0] = sc.nextInt();
        System.out.print("e: ");
        matriz[1][1] = sc.nextInt();
        System.out.print("f: ");
        matriz[1][2] = sc.nextInt();
        System.out.print("g: ");
        matriz[2][0] = sc.nextInt();
        System.out.print("h: ");
        matriz[2][1] = sc.nextInt();
        System.out.print("i: ");
        matriz[2][2] = sc.nextInt();


        matriz = matrizInversa(matriz);
        printMatriz(matriz);
    }


    static public void printMatriz(int[][] mat)
    {
    for (int i = 0; i<mat.length; i++)
    {
        for (int j = 0; j<mat[i].length; j++)
        {
            System.out.print(mat[i][j] + " ");
        }
        System.out.println();
    }
	}

    public static int [][] matrizInversa(int [][] matriz)
    {
        int det = 1/determinante(matriz);
        int [][] matrizaux = matrizAdjunta(matriz);
        multiplicarMatriz(det,matrizaux);

        
        
        return matrizaux;
    }

    public static void multiplicarMatriz(int n, int [][] matriz)
    {
        for(int i=0; i<matriz.length; i++)
            for(int j=0; j<matriz.length; j++)
                matriz[i][j]*=n;
    }

    public static int [][] matrizAdjunta(int [][] matriz)
    {
        return matrizTranspuesta(matrizCofactores(matriz));
    }

    public static int [][] matrizCofactores(int [][] matriz)
    {
        int [][] matrizCof = new int [matriz.length][matriz.length];
        int [][] det = new int [matriz.length-1][matriz.length-1];
        int detValor;
        int indice1,indice2;
        for(int i=0; i<matriz.length; i++)
        {
            for(int j=0; j<matriz.length; j++)
            {
                for(int k=0; k<matriz.length; k++)
                {
                    if(k!=i) {
                        for(int l=0; l<matriz.length; l++)
                        {
                            if(l!=j)
                            {
                                indice1 = (k<i ? k : k-1);
                                indice2 = (l<j ? l : l-1);
                                det[indice1][indice2]=matriz[k][l];
                            }
                        }
                    }
                }
                detValor = determinante(det);
                matrizCof[i][j] = detValor * (int)Math.pow(-1, i+j+2);
            }
        }
        return matrizCof;
    }

    public static int [][] matrizTranspuesta(int [][] matriz)
    {
        int [][] matrizTrans = new int [matriz[0].length][matriz.length];
        for(int i=0; i<matriz.length; i++)
        {
            for(int j=0; j<matriz.length; j++)
                matrizTrans[i][j]=matriz[j][i];
        }
        return matrizTrans;
    }

    public static int determinante(int [][] matriz)
    {
        int det;
        int suma = 0;
        int [][] nm = new int [matriz.length-1][matriz.length-1];
		int indice = -1;

        if(matriz.length==2)
        {
            det = (matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
            return det;
        }

        for(int i=0; i<matriz.length; i++)
        {
            for(int j=0; j<matriz.length; j++)
            {
                if(j!=i){
                    for(int k=1; k<matriz.length; k++)
                    {
                        if(j<i)
                            indice=j;
                        else if(j>i)
                            indice = j-1;
                            nm[indice][k-1] = matriz[j][k];
                    }
                }
            }

            if(i%2 == 0)
                suma += matriz[i][0] * determinante(nm);
            else
                suma -= matriz[i][0] * determinante(nm);
        }
        return suma;
    }
}
