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
        for (int i=0; i<num_goods; i++) {
            String[] s = br.readLine().split(" ");
            price[i] = Integer.parseInt(s[0]);
        }

        // �L�����y�[���ݒ���z�̎擾
        int[] set_price = new int[day_campaign];
        for (int i=0; i<day_campaign; i++) {
            String[] s = br.readLine().split(" ");
            set_price[i] = Integer.parseInt(s[0]);
        }

        // �L�����y�[���ݒ���z�ɍł��߂��������z�̎Z�o�ƕ\��
        for (int i=0; i<day_campaign; i++) { // �L�����y�[���̓������J��Ԃ�
            int max_combi=0;
            for (int j=0; j<num_goods-1; j++) { // ���i�̐�-1�����J��Ԃ�
                for (int k=j+1; k<num_goods; k++) { // �����ȍ~�̏��i�̐������J��Ԃ�
                    int combi = price[j] + price[k];
                    if (combi == set_price[i]) { // �������z���ݒ���z�Ɠ����Ȃ玟��
                        max_combi = combi;
                        break;
                    } else if (combi <= set_price[i] && combi > max_combi) {
                        max_combi = combi;
                    }
                }
                if (max_combi == set_price[i]) break; // �������z���ݒ���z�Ȃ玟��
            }
            System.out.println(max_combi); // �ݒ���z�ɍł��߂��������z��\��
        }
    }
}
