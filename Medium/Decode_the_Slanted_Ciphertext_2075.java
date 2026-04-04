package Medium;

public class Decode_the_Slanted_Ciphertext_2075 {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1)
            return encodedText;

        int n = encodedText.length();
        int cols = n / rows;

        char[][] grid = new char[rows][cols];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = encodedText.charAt(idx++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            int r = 0, c = j;
            while (r < rows && c < cols) {
                sb.append(grid[r][c]);
                r++;
                c++;
            }
        }
        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ')
            end--;
        return sb.substring(0, end + 1);
    }
}
