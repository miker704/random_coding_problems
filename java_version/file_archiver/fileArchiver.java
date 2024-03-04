package file_archiver;

// You need to transfer some information through a slow datalink as fast as possible. 
// You consider using a file archiver to compress data before sending.

// The first line of input contains an integer dataSize - the size of data you need to transfer 
// in bytes. 1 <= dataSize <= 10000.
// The second line of input contains an integer transferSpeed - the speed of data transfer through the link, 
// in bytes per second. 1 <= transferSpeed <= 10.
// The third line of input contains an integer N - the number of archivers you are considering. 1 <= N <= 2.
// The following N lines contain information about archivers, each line describing one archiver with two
//  space-separated integers: processingSpeed - the speed of data processing (both compression and extraction) 
//  in bytes per second, and compressionRate - the rate of compression achieved by the archiver
//   (i.e. the size of compressed data divided by the size of original data), 
//   in percent. 1 <= processingSpeed <= 100, 1 <= compressionRate <= 99.

// Output the minimal time you'll need to send the data through the datalink, including compression 
// and extraction time, rounded up to the nearest integer. Round up only the final answer, not
//  intermediary calculations results.

// Example

// input

// 1000
// 10
// 2
// 100 50
// 60 20

// output

// 40

// Sending the data uncompressed will take 1000/10 = 100 seconds.
// Using first archiver will take 1000/100 + 1000*0.5/10 + 1000*0.5/100 = 65 seconds.
// Using second archiver will take 1000/60 + 1000*0.2/10 + 1000*0.2/60 = 40 seconds.

public class fileArchiver {

    public static void main(String[] args) {
        String[] inputs = { "1000", "10", "2" };
        String[] archivers = { "100 50", "60 20" };
        int dataSize = Integer.parseInt(inputs[0]);
        int transferSpeed = Integer.parseInt(inputs[1]);
        int n = Integer.parseInt(inputs[2]);

        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] archiverInfo = archivers[i].split(" ");
            int processorSpeed = Integer.parseInt(archiverInfo[0]);
            int compressionRate = Integer.parseInt(archiverInfo[1]);

            int time = calculateTime(dataSize, transferSpeed, processorSpeed, compressionRate);
            minTime = Math.min(minTime, time);
        }
        System.out.println((int) Math.ceil(minTime));
    }

    private static int calculateTime(int dataSize, int transferSpeed, int processorSpeed, int compressionRate) {

        // calculate this entire mess
        double compressionTime = dataSize / processorSpeed;
        double transferTime = dataSize * ((compressionRate / 100.00) / transferSpeed);
        double processingTime = dataSize * ((compressionRate / 100.00) / processorSpeed);
        return (int) Math.ceil(compressionTime + transferTime + processingTime);
    }

}
