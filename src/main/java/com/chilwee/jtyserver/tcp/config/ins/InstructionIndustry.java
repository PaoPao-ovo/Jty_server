package com.chilwee.jtyserver.tcp.config.ins;

import com.chilwee.jtyserver.tcp.config.ins.inscontent.InsContent;

public class InstructionIndustry {

    private InsContent insContent;

    public InstructionIndustry(){};

    public InstructionIndustry(InsContent insContent) {
        this.insContent = insContent;
    }

    //  静态方法，计算CRC校验值
    public static String getCRC2(byte[] bytes) {
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;

        int i, j;
        for (i = 0; i < bytes.length; i++) {
            CRC ^= (int) bytes[i];
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) == 1) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }
        //高低位转换
        CRC = ((CRC & 0x000000FF) << 8) | ((CRC & 0x0000FF00) >> 8);

        return Integer.toHexString(CRC);
    }


    public InsContent getInsContent() {
        return insContent;
    }

    public void setInsContent(InsContent insContent) {
        this.insContent = insContent;
    }

    public byte[] GetInstruction() {
        return new byte[1];
    }

    public int GetOriginVol(InsContent insContent){

        return 0;
    };
}
