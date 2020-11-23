package Exercise.impl;

import Exercise.inter.Caculator;
import Exercise.utils.LogUtils;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @date 2020/11/21-16:39
 */
@Service
public class MathCaculator implements Caculator {
    @Override
    public int add(int i, int j) {
        int res=i+j;
        return res;
    }

    @Override
    public int sub(int i, int j) {
        int res=i-j;
        return res;
    }

    @Override
    public int mul(int i, int j) {
        int res=i*j;
        return res;
    }

    @Override
    public int div(int i, int j) {
        int res=i/j;
        return res;
    }
}
