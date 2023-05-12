
DROP TABLE IF EXISTS public.transaction_item, public.transaction,  public.item;
DROP SEQUENCE IF EXISTS seq_item_id, seq_transaction_id, seq_transaction_item_id;




CREATE TABLE public.item(
	id serial NOT NULL PRIMARY KEY,
	name varchar(50) UNIQUE NOT NULL,
	picture varchar(500) NOT NULL,
	calories int NOT NULL,
	toppings text[],
	type varchar(30) NOT NULL,
	price decimal NOT NULL,
	CONSTRAINT chk_item_type CHECK (type IN ('Entree', 'Side', 'Condiment', 'Beverage', 'Treat'))
);

CREATE TABLE public.transaction(
	id serial NOT NULL PRIMARY KEY,
	date date NOT NULL,
	total numeric (9,2) NOT NULL
);


CREATE TABLE public.transaction_item(
	id serial NOT NULL PRIMARY KEY,
	item_id int NOT NULL,
	transaction_id int NOT NULL,
	CONSTRAINT fk_item_id FOREIGN KEY (item_id) REFERENCES item (id),
	CONSTRAINT fk_transaction_id FOREIGN KEY (id) REFERENCES transaction (id)
);

INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Chick-fil-A® Chicken Sandwich', 'https://www.cfacdn.com/img/order/menu/Online/Entrees/Jul19_CFASandwich_pdp.png', 440, Array ['pickles'], 'Entree', 4.59);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Chick-fil-A® Deluxe Sandwich', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Entree/Entree%20PDP/_0000s_0004_NEWStack6200001CFAPDPDeluxeSandwich1085png.png', 500, Array ['Pickles', 'American Cheese', 'Tomato', 'Lettuce'], 'Entree', 5.29);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Spicy Chicken Sandwich', 'https://www.cfacdn.com/img/order/menu/Online/Entrees/CFASpicySandwich_1080.png', 440, Array ['pickles'], 'Entree', 4.99);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Spicy Deluxe Sandwich', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Entree/Entree%20Desktop/_0003s_0012_%5BFeed%5D_0001s_0023_Entrees_Spicy-Deluxe-Sandwich.png', 550, Array ['Pickles', 'Pepper Jack Cheese', 'Tomato', 'Lettuce'], 'Entree', 5.69);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Grilled Chicken Sandwich', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Entree/Entree%20PDP/_0000s_0009_Final__0026_CFA_PDP_Grilled-Deluxe-Sandwich_1085.png', 380, Array ['Lettuce', 'Tomato'], 'Entree', 6.19);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Chick-fil-A® Grilled Chicken Club Sandwich', 'https://www.cfacdn.com/img/order/menu/Online/Entrees/grilledClub_colbyJack_PDP.png', 520, Array ['Colby Jack Cheese', 'Tomato', 'Lettuce', 'Bacon'], 'Entree', 7.85);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Chick-fil-A® Nuggets', 'https://www.cfacdn.com/img/order/menu/Online/Entrees/nuggets_8ct_PDP.png', 250, 'Entree', 4.65);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Grilled Nuggets', 'https://www.cfacdn.com/img/order/menu/Online/Entrees/grilledNuggets_8ct_PDP.png', 130, 'Entree', 5.55);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Chick-fil-A Chick-n-Strips®', 'https://www.cfacdn.com/img/order/menu/Online/Entrees/strips_3ct_PDP.png', 310, 'Entree', 4.95);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Chick-fil-A® Cool Wrap', 'https://www.cfacdn.com/img/order/menu/Online/Entrees/wrap_pdp.png', 660, Array ['Lettuce', 'Montery Jack and Cheddar Cheeses'], 'Entree', 7.49);

INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Small Chick-fil-A Waffle Potato Fries®', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/Small_Lowered_1217shoot_1080x1080.png', 320, Array ['Butter'], 'Side', 2.19);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Medium Chick-fil-A Waffle Potato Fries®', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/Medium_Lowered_1217shoot_1080x1080.png', 420, Array ['Butter'], 'Side', 2.45);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Large Chick-fil-A Waffle Potato Fries®', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/Large_Lowered_1217shoot_1080x1080.png', 600, Array ['Butter'], 'Side', 2.89);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Small Fruit Cup', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Sides/Sides%20PDP/_0000s_0010_%5BFeed%5D_0003s_0002_Sides_Fruit-Cup.png', 50, Array ['Apple', 'Orange', 'Blueberries'], 'Side', 3.19);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Medium Fruit Cup', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Sides/Sides%20PDP/_0000s_0010_%5BFeed%5D_0003s_0002_Sides_Fruit-Cup.png', 60, Array ['Apple', 'Orange', 'Blueberries'], 'Side', 4.09);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Side Salad', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/sideSalad_pdp.png', 470, Array ['Mixed Greens', 'Montery Jack and Cheddar Cheeses', 'Grape Tomatoes'], 'Side', 4.19);
INSERT INTO public.item(name, picture, calories, type, price)VALUES ('Small Mac & Cheese', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Sides/Sides%20PDP/MacnCheese_5oz_pdp.png', 270, 'Side', 3.29);
INSERT INTO public.item(name, picture, calories, type, price)VALUES ('Medium Mac & Cheese', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Catering/Catering%20PDP/031417_MacnCheese_SmTray_CateringSize_Prod_CMYK_0038-V4_2880px.png', 450, 'Side', 4.09);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Cup of Chicken Noodle Soup', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/Chicken-Noodle-Soup_Small_PDP.png', 170, Array ['Chopped Carrots', 'Chopped Celery', 'Egg Noodles', 'Broth'], 'Side', 3.95);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Bowl of Chicken Noodle Soup', 'https://www.cfacdn.com/img/order/COM/PDP/Sides/PDP%20Chicken%20Noodle%20Soup.png', 280, Array ['Chopped Carrots', 'Chopped Celery', 'Egg Noodles', 'Broth'], 'Side', 6.09);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Kale Crunch Side', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/kaleCrunch_lg_pdp.png', 170, Array ['Kale', 'Apple Cider', 'Dijon Mustard Vinaigrette'], 'Side', 4.09);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Greek Yogurt Parfait w/ Granola', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/Jul19_OrganicAussieGreekYogurtParfaitCupGranola_pdp.png', 270, Array ['Organic Vanilla Yogurt', 'Blueberries', 'Strawberries', 'Granola'], 'Side', 4.79);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Greek Yogurt Parfait w/ Cookie Crumbs', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/Jul19_OrganicAussieGreekYogurtParfaitCupCookie_pdp.png', 240, Array ['Organic Vanilla Yogurt', 'Blueberries', 'Strawberries', 'Oreo Cookie Crumbs'], 'Side', 4.79);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Waffle Potato Chips', 'https://www.cfacdn.com/img/order/menu/Online/Drinks/chips_1080.png', 220, Array ['Sea Salt'], 'Side', 2.09);
INSERT INTO public.item(name, picture, calories, toppings, type, price)VALUES ('Buddy Fruits® Apple Sauce', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/Buddy_Fruits_PDP.png', 45, Array ['Sliced Apples', 'Apple Juice', 'Cinnamon'], 'Side', 2.39);

INSERT INTO item (name, picture, calories, type, price) VALUES ('Sweet Tea', 'https://www.cfacdn.com/img/order/menu/Online/Drinks/tea_pdp.png', 120, 'Beverage', 2.09);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Unsweet Tea', 'https://www.cfacdn.com/img/order/menu/Online/Drinks/tea_pdp.png', 0, 'Beverage', 2.09);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Chick-Fil-A® Lemonade', 'https://www.cfacdn.com/img/order/menu/Online/Drinks/lemonade_pdp.png', 220, 'Beverage', 2.39);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Chick-Fil-A® Diet Lemonade', 'https://www.cfacdn.com/img/order/menu/Online/Drinks/lemonade_pdp.png', 50, 'Beverage', 2.39);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Iced Coffee', 'https://www.cfacdn.com/img/order/menu/Online/Drinks/2022IcedCoffee_1080x1080.png', 150, 'Beverage', 3.09);
INSERT INTO item (name, picture, calories, type, price) VALUES ('DASANI® Bottled Water', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Drinks/Drinks%20PDP/_0000s_0026_%5BFeed%5D_0006s_0014_Drinks_Dasani-Water.png', 0, 'Beverage', 2.19);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Simply Orange®', 'https://www.cfacdn.com/img/order/menu/Online/Drinks/SimplyOJ_Oct19_PDP.png', 160, 'Beverage', 2.89);
INSERT INTO item (name, picture, calories, type, price) VALUES ('1%  Chocolate Milk', 'https://www.cfacdn.com/img/order/menu/Mobile/Kids%20Meals/Parent/220121_Milk_Choc_0009_1080x1080.png', 140, 'Beverage', 1.69);
INSERT INTO item (name, picture, calories, type, price) VALUES ('1% Milk', 'https://www.cfacdn.com/img/order/menu/Mobile/Kids%20Meals/Parent/220121_Milk_Reg_0009_1080x1080.png', 90, 'Beverage', 1.69);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Coffee', 'https://www.cfacdn.com/img/order/menu/Online/Drinks/Dec19_Coffee_pdp.png', 0, 'Beverage', 2.09);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Coca-Cola®', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Drinks/Drinks%20PDP/_0000s_0022_Feed_Menu_0000_Drinks_Coca-cola.png', 140, 'Beverage', 2.09);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Dr Pepper®', 'https://www.cfacdn.com/img/order/menu/Mobile/Beverages/Parent/DrPepper_PaperCup_straight_wet_1200x1200.png', 180, 'Beverage', 2.09);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Sprite®', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Drinks/Drinks%20PDP/_0000s_0032_%5BFeed%5D_0006s_0008_Drinks_Sprite.png', 190, 'Beverage', 2.09);


INSERT INTO item (name, picture, calories, type, price) VALUES ('Colby Jack Cheese', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/cheese_colbyJack_PDP.png', 80, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Pepper Jack Cheese', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/cheese_pepperJack_PDP.png', 80, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('American Cheese', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/cheese_american_PDP.png', 50, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Bacon', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/bacon_smokehouse_PDP.png', 50, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Lettuce', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/lettuce_PDP.png', 5, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Tomato', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/tomatoes_PDP.png', 5, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Pickles', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/pickles_2ct_PDP.png', 0, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Chick-fil-A® Sauce', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/Sauces/sauces_1ozPDP/Sauce_CFA-Sauce_PDP.png', 140, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Polynesian Sauce', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/Sauces/sauces_1ozPDP/Sauce_Polynesian_PDP.png', 110, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Barbeque Sauce', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/Sauces/sauces_1ozPDP/Sauce_Barbeque_PDP.png', 45, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Honey Mustard Sauce', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/Sauces/sauces_1ozPDP/Sauce_Honey-Mustard_PDP.png', 50, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Garden Herb Ranch Saurce', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/Sauces/sauces_1ozPDP/Sauce_Garden-Herb-Ranch_PDP.png', 140, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Zesty Buffalo Sauce', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/Sauces/sauces_1ozPDP/PDP_1oz-Sauce_Buffalo.png', 25, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Sweet and Spicy Sriracha Sauce', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/Sauces/sauces_1ozPDP/Sauce_Sweet-and-Spicy-Sriracha_PDP.png', 45, 'Condiment', 0);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Honey Roasted BBQ Sauce', 'https://www.cfacdn.com/img/order/menu/Online/Modifiers/Condiments_full-res_Honey-Roasted-BBQ_PDP.png', 60, 'Condiment', 0);


INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Frosted Lemonade', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Treats/Treats%20PDP/_0000s_0003_%5BFeed%5D_0005s_0001_Treats_Frosted-Lemonade.png', 330, Array ['Lemonade', 'Icedream'], 'Treat', 4.15);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Frosted Coffee', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Treats/Treats%20Desktop/_0001s_0004_%5BFeed%5D_0005s_0000_Treats_Frosted-Coffee.png', 250, Array ['Ice-Brewed Coffee', 'Icedream'], 'Treat', 4.15);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Chocolate Chunk Cookie', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/PDP_CCCookie.png', 370, Array ['Dark and Milk Chocolate Chunks', 'Wholesome Oats'], 'Treat', 1.55);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Chocolate Fudge Brownie', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Treats/Treats%20PDP/031717_FudgeChunkBrownie_PDP.png', 380, Array ['Chocolate', 'Chocolate Fudge'], 'Treat', 2.15);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Cookies & Cream Milkshake', 'https://www.cfacdn.com/img/order/menu/Mobile/Desserts/Menu%20Item/16oz_C%26C_Milkshake-1080.png', 630, Array ['Oreo Cookie Crumbs', 'Whipcream', 'Cherry'], 'Treat', 4.25);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Chocolate Milkshake', 'https://www.cfacdn.com/img/order/menu/Mobile/Desserts/Menu%20Item/16oz_ChocolateMilkshake-1080.png', 590, Array ['Hershey''s Chocolate Syrup', 'Whipcream', 'Cherry'], 'Treat', 4.25);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Strawberry Milkshake', 'https://www.cfacdn.com/img/order/menu/Mobile/Desserts/Menu%20Item/16oz_StrawberryMilkshake-1080.png', 570, Array ['Strawberry Syrup', 'Whipcream', 'Cherry'], 'Treat', 4.25);
INSERT INTO item (name, picture, calories, toppings, type, price) VALUES ('Vanilla Milkshake', 'https://www.cfacdn.com/img/order/menu/Mobile/Desserts/Menu%20Item/16oz_VanillaMilkshake-1080.png', 580, Array ['Whipcream', 'Cherry'], 'Treat', 4.25);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Chick-fil-A® Icedream® Cone', 'https://www.cfacdn.com/img/order/COM/Menu_Refresh/Drinks/Drinks%20PDP/_0000s_0027_%5BFeed%5D_0006s_0013_Drinks_Ice-Dream.png', 180, 'Treat', 1.68);
INSERT INTO item (name, picture, calories, type, price) VALUES ('Chick-fil-A® Icedream® Cup', 'https://www.cfacdn.com/img/order/menu/Online/Sides%26treats/IceDream_RedCup_1080x1080.png', 140, 'Treat', 1.35);





