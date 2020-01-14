import com.aliyuncs.exceptions.ClientException;
import com.itheima.utils.SMSUtils;
import org.junit.Test;

public class aliyunSMS {
    @Test
    public void test(){
        try {
            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE,"15959221543","6969");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE,"15959221543","6969");
    }
}
