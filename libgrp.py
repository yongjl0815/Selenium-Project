# -*- coding: utf-8 -*-
import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver.common.by import By



class PythonSiteSearch(unittest.TestCase):
    
    global pass_check_counter
    global total_checks
    
    def __init__(self):
        self.pass_check_counter = 0
        self.total_checks = 0
        
    def setUp(self, address):
        # create a new Firefox session
        self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(20)
        self.driver.get(address) 

    def navigateBack(self):
        self.driver.implicitly_wait(10)
        self.driver.back()
        
        
        
    # check title        
    def test_title(self, title):      
        self.total_checks += 1
        self.driver.implicitly_wait(10)
        if (self.driver.title == title):
            self.pass_check_counter += 1
        else:
            print ("=====> Title check failed")
            print ("Actual title is", self.driver.title)
            print ("Expected title is", title)



#===== By Class
    #check if an element is present 
    def test_By_Class(self, name):
        self.total_checks += 1
        try:
            self.assertIsNotNone(self.driver.find_element_by_class_name(name))
            self.pass_check_counter += 1
        except:
            print ("=====> Class", name, "is not present") 

    # check link
    def test_Link_By_Class(self, name): 
        self.total_checks += 1
        try:
            images_link = self.driver.find_element_by_class_name(name)           
            try:
                images_link.click()
                self.pass_check_counter += 1
            except:
                print ("=====> Link", name, "can't be clicked")
        except:
            print ("=====> Link", name, "is not present")

    # make sure search bar works
    def test_Search_Box_Class(self, name, keyWord):
        # locate, enter, and search        
        self.elem = self.driver.find_element_by_class_name(name)
        self.elem.clear()
        self.elem.send_keys(keyWord)
        self.elem.send_keys(Keys.RETURN)
        # makesure search result is not empty
        assert "No results found." not in self.driver.page_source
            
            

#===== By Id
    #check if an element is present 
    def test_By_Id(self, name):
        self.total_checks += 1
        try:
            self.assertIsNotNone(self.driver.find_element_by_id(name))
            self.pass_check_counter += 1
        except:
            print ("=====> Id", name, "is not present") 

    # check link
    def test_Link_By_Id(self, name): 
        self.total_checks += 1
        try:
            images_link = self.driver.find_element_by_id(name)           
            try:
                images_link.click()
                self.pass_check_counter += 1
            except:
                print ("=====> Link", name, "can't be clicked")
        except:
            print ("=====> Link", name, "is not present")
            
    # make sure search bar works
    def test_Search_Box_Id(self, name, keyWord):
        # locate, enter, and search        
        self.elem = self.driver.find_element_by_id(name)
        self.elem.clear()
        self.elem.send_keys(keyWord)
        self.elem.send_keys(Keys.RETURN)
        # makesure search result is not empty
        assert "No results found." not in self.driver.page_source    
        
            

#===== By Name
    #check if an element is present 
    def test_By_Name(self, name):
        self.total_checks += 1
        try:
            self.assertIsNotNone(self.driver.find_element_by_name(name))
            self.pass_check_counter += 1
        except:
            print ("=====> Name", name, "is not present") 

    # check link
    def test_Link_By_Name(self, name): 
        self.total_checks += 1
        try:
            images_link = self.driver.find_element_by_name(name)           
            try:
                images_link.click()
                self.pass_check_counter += 1
            except:
                print ("=====> Link", name, "can't be clicked")
        except:
            print ("=====> Link", name, "is not present")

    # make sure search bar works
    def test_Search_Box_Name(self, name, keyWord):
        # locate, enter, and search        
        self.elem = self.driver.find_element_by_name(name)
        self.elem.clear()
        self.elem.send_keys(keyWord)
        self.elem.send_keys(Keys.RETURN)
        # makesure search result is not empty
        assert "No results found." not in self.driver.page_source
        

         
#===== By Tag
    #check if an element is present 
    def test_By_Tag(self, name):
        self.total_checks += 1
        try:
            self.assertIsNotNone(self.driver.find_element_by_tag_name(name))
            self.pass_check_counter += 1
        except:
            print ("=====> Tag", name, "is not present") 

    # check link
    def test_Link_By_Tag(self, name): 
        self.total_checks += 1
        try:
            images_link = self.driver.find_element_by_tag_name(name)           
            try:
                images_link.click()
                self.pass_check_counter += 1
            except:
                print ("=====> Link", name, "can't be clicked")
        except:
            print ("=====> Link", name, "is not present")
 
    # make sure search bar works
    def test_Search_Box_Tag(self, name, keyWord):
        # locate, enter, and search        
        self.elem = self.driver.find_element_by_tag_name(name)
        self.elem.clear()
        self.elem.send_keys(keyWord)
        self.elem.send_keys(Keys.RETURN)
        # makesure search result is not empty
        assert "No results found." not in self.driver.page_source           
            
            
#===== By CSS
    #check if an image is present 
    def test_Image_By_Css(self, name):
        self.total_checks += 1
        try:
            self.elem = self.driver.find_element_by_css_selector(name)
            self.assertIsNotNone(self.elem)
            #print ("==> Image", self.elem.get_attribute('src'), "is present")
            self.pass_check_counter += 1
        except:
            print ("=====> Image", name, "is not present") 

    #check if an image is present 
    def test_Text_By_Css(self, name):
        self.total_checks += 1
        try:
            self.elem = self.driver.find_element_by_css_selector(name)
            self.assertIsNotNone(self.elem)
            #print ("==> Text", self.elem.text, "is present")
            self.pass_check_counter += 1
        except:
            print ("=====> Image", name, "is not present") 



#===== By Link Text
    # check images link
    def test_Link_By_Link_text(self, name): 
        self.total_checks += 1
        try:
            images_link = self.driver.find_element_by_link_text(name)   
            try:
                images_link.click()
                self.pass_check_counter += 1
            except:
                print ("=====> Link", name, "can't be clicked")
        except:
            print ("=====>  Link", name, "is not present")
 
    
       
    def printResult(self):
        print("--------------------------------------------------------------")
        print("Total test ran = ", self.total_checks)
        print("Total test passed = ", self.pass_check_counter)
        print("--------------------------------------------------------------")
        
        
        
    def tearDown(self):
        # close site
        self.driver.close()               
           