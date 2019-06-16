package newpackage;


public class MyClass {

	public static void main(String[] args) {
		
		Lib sess = new Lib();
		
		//Connect
		sess.setUp("https://s1.demo.opensourcecms.com/wordpress/");

		sess.test_Title("opensourcecms – Just another WordPress site");
		

		//Check background image
		sess.test_Image_By_Css("img[alt='opensourcecms']"); // background image


		// check if a text is present by css
		sess.test_Text_By_Css("section//recent-posts-2 h2"); // text - recent posts
		sess.test_Text_By_Css("section//recent-comments-2 h2"); // text - recent comments
		sess.test_Text_By_Css("section//archives-2 h2"); // text - archives
		sess.test_Text_By_Css("section//categories-2 h2"); // text - categories                     
		sess.test_Text_By_Css("section//meta-2 h2"); // text - meta
		sess.test_Text_By_Css("div.entry-content p"); // text - Welcome to WordPress. This is your first post. Edit or delete it, then start writing!

		                      
		// check if an element is present by class
		sess.test_By_Class("page-title"); // text - posts


		// check if a link works by Class
		sess.test_Link_By_Class("menu-scroll-down"); // down arrow
		sess.test_Link_By_Class("site-title"); // link - opensourcecms

		sess.test_Link_By_Class("imprint"); // link - Proudly powered by WordPress 
		sess.test_Title("Blog Tool, Publishing Platform, and CMS — WordPress");
		sess.navigateBack();
		sess.test_Link_By_Class("entry-title"); // link - Hello World!
		sess.test_Title("Some crappy title here – opensourcecms");
		sess.navigateBack();
		sess.test_Link_By_Class("entry-meta"); // link - October 2, 2018
		sess.test_Title("opensourcecms – Just another WordPress site");
		sess.navigateBack();
		sess.test_Link_By_Class("comment-author-link"); // link - A WordPress Commentor under recent comments
		sess.test_Title("Blog Tool, Publishing Platform, and CMS — WordPress");
		sess.navigateBack();



		// check if a link works by Id
		sess.test_Link_By_Id("recent-posts-2");// link - Hello World! under recent posts
		sess.test_Title("opensourcecms – Just another WordPress site");
		sess.navigateBack();
		sess.test_Link_By_Id("archives-2"); // link - October 2018 under Archives
		sess.test_Title("opensourcecms – Just another WordPress site");
		sess.navigateBack();
		sess.test_Link_By_Id("meta-2"); // link - October 2018 under Archives
		sess.test_Title("opensourcecms – Just another WordPress site");
		sess.navigateBack();


		// verify search box
		//sess.test_Search_Box_Id("search-form-1", "post");


		//check if a link works by link text
		sess.test_Link_By_Link_text("Uncategorized");
		sess.test_Title("Uncategorized – opensourcecms");
		sess.navigateBack();
		sess.test_Link_By_Link_text("Log in");
		sess.test_Title("Log In ‹ opensourcecms — WordPress");
		sess.navigateBack();
		sess.test_Link_By_Link_text("Entries RSS");
		sess.test_Title("opensourcecms – Just another WordPress site");
		sess.navigateBack();
		sess.test_Link_By_Link_text("Comments RSS");
		sess.test_Title("opensourcecms – Just another WordPress site");
		sess.navigateBack();
		sess.test_Link_By_Link_text("WordPress.org");
		sess.test_Title("Blog Tool, Publishing Platform, and CMS — WordPress");
		sess.navigateBack();
		
		
		//Print Result
		sess.printResult();
		
		
		//End
	    sess.tearDown();
	    System.exit(0);
       
    }

}