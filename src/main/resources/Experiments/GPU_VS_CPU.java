package main.resources.Experiments;

public class GPU_VS_CPU {

    public static void main(String[] args) {
        // Initialize vectors
        int size = 1000000;
        double[] aArray = new double[size];
        double[] bArray = new double[size];
        for (int i = 0; i < size; i++) {
            aArray[i] = 1.0;
            bArray[i] = 2.0;
        }

        // Measure CPU execution time for array addition
        long startCpuArray = System.currentTimeMillis();
        double[] cCpuArray = cpuVectorAdd(aArray, bArray);
        long endCpuArray = System.currentTimeMillis();

        // Measure CPU execution time for matrix addition
        long startCpuMatrix = System.currentTimeMillis();
        double[] cCpuMatrix = cpuMatrixAdd(aArray, bArray);
        long endCpuMatrix = System.currentTimeMillis();

        // Output results
        System.out.println("Vector addition result (CPU Array): " + cCpuArray[0]);
        System.out.println("Vector addition result (CPU Matrix): " + cCpuMatrix[0]);
        System.out.println("CPU execution time (Array): " + (endCpuArray - startCpuArray) + " ms");
        System.out.println("CPU execution time (Matrix): " + (endCpuMatrix - startCpuMatrix) + " ms");
    }

    public static double[] cpuVectorAdd(double[] a, double[] b) {
        int size = a.length;
        double[] c = new double[size];
        for (int i = 0; i < size; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public static double[] cpuMatrixAdd(double[] a, double[] b) {
        int size = a.length;
        double[] c = new double[size];
        for (int i = 0; i < size; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }
}
