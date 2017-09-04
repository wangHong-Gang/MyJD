package com.jd;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDJ {
	private ChromeDriver driver;
	private String url = "https://www.jd.com/";

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.get(url);
		// 設置浏览器最大化
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws Exception {
		// 点击登陆
		driver.findElementByClassName("link-login").click();
		// 获取到当前的url
		System.out.println(driver.getCurrentUrl());
		// 使用 账号登陆
		driver.findElementByCssSelector("div.login-tab.login-tab-r").click();

		// 输入用户名和密码：
		driver.findElementById("loginname").sendKeys("15701574563");
		driver.findElementById("nloginpwd").sendKeys("wan147258369..");

		// 点击登陆
		driver.findElementById("loginsubmit").click();
		Thread.sleep(3000);

		// 点击京东会员
		driver.findElementByLinkText("京东会员").click();

		for (int i = 0; i < 9; i++) {
			Set<String> handles = driver.getWindowHandles();
			for (String string : handles) {
				driver.switchTo().window(string);
				String title = driver.getTitle();
				if (title.equals("京豆兑换、专享礼包、领优惠券等会员特权，尽在京东会员俱乐部（vip.jd.com）！")) {
					i = 10;
					System.out.println(driver.getCurrentUrl());
					break;
				}
			}
		}
		Thread.sleep(1000);
		// 点击用户签到
		driver.findElementByCssSelector("#checkinBtn > i").click();
		

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();

	}

}
