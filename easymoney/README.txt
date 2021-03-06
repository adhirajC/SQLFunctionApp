The gui has search options for brown rice exclusively and departments exlusively. However, I have also added a search option that searches brown rices available in a certain department store after that department store has been selected. I have done so because it would be redundant to put in another range of search functions in the department store searcher. The original search brown rice function covers all the necessary search options needed for brown rice. All of the integer parameters with the exception of id and score have a max and min input parameter. This is created so it gives the customer an option to choose the price range in which they want to shop and the size range. I have set up score to have a minimum input only because a customer will try to get a food item that has the best score possible and will not be looking for low scoring food items.

The following are search queries that can be utilized for searching through the entries:





1. returns the department id and department name after the user searches it using the department id. You can access this function using the Search Departments tab and then selecting Id for search parameter
INPUT:select depid,title from department where depid=2;
OUTPUT:code: 2 title = Easy Foods


2.returns the department id and department name after the user searches it using the department name. You can access this function using the Search Departments tab and then selecting Name for search parameter
INPUT:select depid,title from department where title like '%al%';
OUTPUT:
code: 1 title = Walmart
code: 6 title = Canadian WholeSale Foods

3.returns the brown rice id and brown rice name after the user searches it using the brown rice name. You can access this function using the Search Brown Rice tab and then selecting name for search parameter
INPUT:select id,name from brown_rice where name like '%jas%';
OUTPUT:code: 1001 title = Best Rice Jasmine
4.returns the brown rice id and brown rice name after the user searches it using the brown rice id. You can access this function using the Search Brown Rice tab and then selecting id for search parameter
INPUT:select id,name from brown_rice where id=1001;
OUTPUT:code: 1001 title = Best Rice Jasmine

5.returns the brown rice id and brown rice name after the user searches it using the brown rice brand name. You can access this function using the Search Brown Rice tab and then selecting brand for search parameter
INPUT:select id,name from brown_rice where brand like '%til%';
OUTPUT:code: 1004 title = Classic Basmati


6.returns the brown rice id and brown rice name after the user searches it using the brown rice type name. You can access this function using the Search Brown Rice tab and then selecting type for search parameter
INPUT:select id,name from brown_rice where type like '%Basmati%';
OUTPUT:
code: 1003 title = Uncle Ben Basmati
code: 1004 title = Classic Basmati


7.returns the brown rice id and brown rice name after the user searches the brown rices available between the sizes inputted. You can access this function using the Search Brown Rice tab and then selecting sizes for search parameter
INPUT:select id,name from brown_rice where size<10 and size>0;
OUTPUT:code: 1001 title = Best Rice Jasmine
code: 1002 title = Easy Rice Long Grain
code: 1003 title = Uncle Ben Basmati
code: 1004 title = Classic Basmati

8.returns the brown rice id and brown rice name after the user searches the brown rices available between the prices inputted. You can access this function using the Search Brown Rice tab and then selecting price for search parameter
INPUT:select id,name from brown_rice were price<10 and price>1;
OUTPUT:code: 1001 title = Best Rice Jasmine
code: 1002 title = Easy Rice Long Grain
code: 1003 title = Uncle Ben Basmati
code: 1004 title = Classic Basmati


9.returns the brown rice id and brown rice name after the user searches the brown rices that have a score more than the one inputted. You can access this function using the Search Brown Rice tab and then selecting score for search parameter
INPUT:select id,name from brown_rice were score>2;
OUTPUT: code: 1001 title = Best Rice Jasmine
code: 1002 title = Easy Rice Long Grain
code: 1003 title = Uncle Ben Basmati
code: 1004 title = Classic Basmati
10.returns the brown rice id and brown rice name after the user selects a department and then searches the brown rices available in that department store. You can access this function by double clicking on the department store and then searching the name by clicking the search parameter
INPUT:select id,name from brown_rice where depid=*selected department depid* and name like '%jas%';
OUTPUT:1001     Best Rice Jasmine
