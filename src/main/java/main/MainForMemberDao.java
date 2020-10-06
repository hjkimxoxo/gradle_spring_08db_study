package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.Member;
import spring.MemberDao;

public class MainForMemberDao {
	private static MemberDao memberDao;
	private static ChangePasswordService changePassword;


	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);) {
			DataSource ds = ctx.getBean(DataSource.class);
			System.out.println(ds);
			
			memberDao = ctx.getBean(MemberDao.class);
			
			
			//memberDao.insert(new Member("test6@test.co.kr", "1234", "test5", LocalDateTime.now()));
			
			selectByEmail();
			selectAll();
			//insertMember();
			//selectAll();
			deleteMember();
			selectAll();
			

		}
	}
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");

	private static void selectByEmail() {
		System.out.println("selectByEmail()");
		Member member = memberDao.selectByEmail("test@test.co.kr");
		System.out.printf("%d : %s : %s%n", member.getId(), member.getEmail(), member.getName());
	}
	
	private static void selectAll() {
		System.out.println("selectAll()");
		List<Member> list = memberDao.selectAll();
		for(Member m:list) {
			System.out.printf("%d : %s : %s%n", m.getId(), m.getEmail(), m.getName());
		}
	}
	
	private static void insertMember() {
		System.out.println("insertMember()");
		Member member = new Member("test7@test.co.kr", "1234", "test7", LocalDateTime.now());
//		String prefix = formatter.format(LocalDateTime.now());
//		Member member = new Member(prefix + "@test.co.kr", prefix, prefix, LocalDateTime.now());
		memberDao.insert(member);
		System.out.println(member.getId() + "데이터추가");
	}
	
	private static void deleteMember() {
		System.out.println("deleteMember()");
		Member member = memberDao.selectByEmail("test7@test.co.kr");
		memberDao.delete(member);
	}
	
	private static void updateMember() {
		System.out.println("updateMember() -- 5번 ");
		Member selectMember = memberDao.selectByEmail("test5@test.co.kr");
		String oldPwd = selectMember.getPassword();
		String newPwd = Double.toHexString(Math.random());
	
	}
	

}
