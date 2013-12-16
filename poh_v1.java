import java.io.*;
class  poh_v1 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ���i�����ƃL�����y�[�������̎擾
        String[] sa = br.readLine().split(" ");
        int num_goods    = Integer.parseInt(sa[0]); // ���i����
        int day_campaign = Integer.parseInt(sa[1]); // �L�����y�[������

        // ���i���z�̎擾
        int[] price = new int[num_goods];
        for (int i=0; i < num_goods; i++) {
            String[] s = br.readLine().split(" ");
            price[i] = Integer.parseInt(s[0]);
        }

        // �L�����y�[���ݒ���z�̎擾
        for (int i=0; i < day_campaign; i++) {
            String s = br.readLine();
            int set_price = Integer.parseInt(s);
            // �ő啡�����i�̃N���A
            int max_combi=0;
            // ���i�̐�-1�����J��Ԃ�
            for (int j=0; j < num_goods-1; j++) {
                // ���i���z���ݒ���z�ȏ�Ȃ玟��
                if (price[j] >= set_price) continue;
                // �����ȍ~�̏��i�̐������J��Ԃ�
                for (int k=j+1; k < num_goods; k++) {
                    int combi = price[j] + price[k];
                    // �������z���ݒ���z�ȏ�Ȃ�Ɠ����Ȃ玟�̓���
                    if (combi > set_price) continue;
                    // �������z���ő���z�ȉ��Ȃ�ő���z�ɑ��
                    if (combi > max_combi) max_combi = combi;
                    // �ő���z���ݒ���z�Ɠ����Ȃ玟�̓���
                    if (max_combi == set_price) break;
                }
                // �ő���z���ݒ���z�Ɠ����Ȃ玟�̓���
                if (max_combi == set_price) break;
            }
            System.out.println(max_combi);
        }
    }
}
