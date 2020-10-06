package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	@Autowired
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	
	public void printAll() {
		//Collection<Member> members = memberDao.selectAll();
		//members.forEach(m -> printer.print(m));
	}

}
