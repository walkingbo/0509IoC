package main;

//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//import ioc.DAOFactory;
import ioc.Player;
import ioc.PlayerDAO;

public class Main {
	//일반 디바이스 용 애플리케이션의 entry point(시작점)
	public static void main(String[] args) {
	
	//try~resource 구문 1.7버전 이상부터 사용 가능
	//()안에서 AutoClosable 인터페이스가 구현된 클래스의 인스턴스를 만들면
	//try~catch 구문이 종료되면 자동으로 close()를 호출 
	try(
	/*
	//Annotation으로 설정된 BeanFactory 클래스 가져오기
	AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(DAOFactory.class)
	*/
	
		//XML 파일을 이용한 ApplicationContext 생성
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("classpath:applicationContext.xml");
			
			){
		//Bean 생성 - playerDAO 라는 id를 가진 bean 태그를 이용해서 
		//PlayerDAO클래스 타입의 객체를 생성해서 리턴
		PlayerDAO dao = context.getBean("playerDAO",PlayerDAO.class);
		
		
		
		/*
		/Bean 생성 - create라는 static 메소드를 이용해서 
		//만들어진 객체를 PlayerDAO클래스를 타입으로 변환해서 리턴 
		PlayerDAO dao = context.getBean("create",PlayerDAO.class);
		PlayerDAO dao1 = context.getBean("create",PlayerDAO.class);
		
		//싱글톤 효과 - 해시 코드 같음 
		System.out.println(dao.hashCode());
		System.out.println(dao1.hashCode());
		*/
		
		Player player = dao.getPlayer();
		System.out.println(player);

			
			
			
			
	}catch(Exception e) {
		System.out.println("Spring IoC 예외:"+e.getMessage());
		e.printStackTrace();
		}
	}
}