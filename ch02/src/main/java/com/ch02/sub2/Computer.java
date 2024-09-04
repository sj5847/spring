package com.ch02.sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com")  //name 속성값
public class Computer {

    //필트 주입
    @Autowired
    private CPU cpu;

    //생성자 주입
    private  RAM ram;

    @Autowired  //생성자에 주입하는것을 권장
    public Computer(RAM ram) {
        this.ram = ram;
    }

    private SSD ssd;

    @Autowired  //세터로도 주입이 가능
    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public void show() {
        cpu.show();
        ram.show();
        ssd.show();
    }

}
