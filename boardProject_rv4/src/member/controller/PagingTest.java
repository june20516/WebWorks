package member.controller;
class   Paging{
	int  total ;
	int   pageCount ;  // 페이지당 6개씩 
	
	int  totalpage;//  1~endPage
	int startNo;
	int endNo;
	int pageStart;// 현재페이지
	public Paging() {
		totalpage=total/pageCount +((total%pageCount==0)?0:1);
	}
}
public class PagingTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  total =34;
		int   pageCount =6;  // 페이지당 6개씩 
		
		int  totalpage=total/pageCount +((total%pageCount==0)?0:1);
		int  temp;
	for(int pageStart=1 ;  pageStart <=  totalpage     ; pageStart++ ) {
		System.out.print(pageStart+":");
		temp =total - pageCount * (pageStart-1);
		for(int s= temp ; s  >  temp-pageCount  ;  s--) {
			System.out.print(s +"  ");
			if(s==1)break;
		}
		System.out.println();
		}
	}

}
