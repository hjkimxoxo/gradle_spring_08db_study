package main;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

public class MainForCPS {
	private static MemberDao memberDao;
	
	
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);) {
			
			memberDao = ctx.getBean(MemberDao.class);
			
//			memberDao.insert(new Member("test54@test.co.kr", "1234", "test", LocalDateTime.now()));
//			System.out.println("회원을 추가했습니다.\n");
//			selectAll();
			
			ChangePasswordService cps = ctx.getBean(ChangePasswordService.class);
			cps.changePassword("test65@test.co.kr", "1234", "new1234");
			System.out.println("암호를 변경했습니다.\n" );
			selectAll();
			
//			Member member = memberDao.selectByEmail("test11@test.co.kr");
//			memberDao.delete(member);
//			System.out.println("회원을 삭제했습니다.\n");
//			selectAll();
		
		} catch (EmptyResultDataAccessException e) {
			System.err.println("존재하지 않는 이메일입니다.\n");
		
		} catch (WrongIdPasswordException e) {
			System.err.println("이메일과 암호가 일치하지 않습니다.\n");
		}

	}

	
	
	private static void selectAll() {
		System.out.println("selectAll()");
		List<Member> list = memberDao.selectAll();
		for(Member m:list) {
			System.out.printf("%d : %s : %s%n", m.getId(), m.getEmail(), m.getName());
		}
		
	}
	
	
}
