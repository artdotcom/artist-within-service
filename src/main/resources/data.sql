insert into asset
values(1, 'Belham Living Atticus Farmhouse Dining Bench', 'UI_001.png', 'BENCH','https://www.hayneedle.com/product/belhamlivingatticusfarmhousediningbench.cfm?rNtt=dime088');

insert into asset
values(2, 'Skyline Tufted Linen Ottoman Bench', 'UI_002.png', 'BENCH','https://www.hayneedle.com/product/tuftedlinenbench.cfm?rNtt=sky806-2');

insert into asset
values(3, 'Belham Living Abbott Parsons Swoop Arm Dining Chair - Set of 2', 'UI_003.png', 'CHAIR','https://www.hayneedle.com/product/belhamlivingabbottparsonsswooparmdiningchairsetof2.cfm?rNtt=redu244-1');

insert into asset
values(4, 'Cool Plant', 'UI_004.png', 'DECOR','');

insert into asset
values(5, 'Nice Plant', 'UI_005.png','DECOR','');

insert into asset
values(6, 'Sprinkle & Bloom Embroidered Geometric Square Decorative Throw Pillow', 'UI_006.png', 'DECOR', 'https://www.hayneedle.com/product/sprinklebloomembroideredgeometricsquaredecorativethrowpillow1.cfm?rNtt=CRAT032');

insert into asset
values(7, 'Simple Round Rug', 'UI_007.png', 'RUG','');

insert into asset
values(8, 'Tall Lamp', 'UI_008.png', 'LAMP','');

insert into asset
values(9, 'Framed Art', 'UI_009.png', 'ART','');

insert into asset
values(10, 'Wood Side Table', 'UI_010.png', 'TABLE','');

insert into asset
values(11, 'Fun Flair', 'UI_011.png', 'DECOR','');


insert into room
values('defaultRoom', '01', 'LeftWall,Frame,ChairLeft,ChairRight,BackWall,Rug,RightCorner,LeftCorner,Vase,Pillow');


insert into region
values('LeftWall', '264, 734, 397, 734, 231, 859, 99, 859', 'BENCH', 'poly');

insert into region
values('ChairLeft', '342,335,720,800', 'CHAIR', 'rect');

insert into region
values('ChairRight', '880,330,1280,820', 'CHAIR', 'rect');

insert into region
values('Frame', '925, 378, 661, 0', 'ART', 'rect');

insert into region
values('Rug', '565,768,1163,869', 'RUG', 'rect');

insert into region
values('BackWall', '638,678,586,734,1007,741,980,681', 'BENCH,TABLE', 'poly');

insert into region
values('RightCorner', '1168,677,1126,721,1251,721,1223,676,1222,165,1305,162,1280,10,1103,13,1076,166,1164,165', 'LAMP', 'poly');

insert into region
values('LeftCorner', '358,214,544,692', 'DECOR', 'rect');

insert into region
values('Pillow', '63,627,277,533,483,545,313,639', 'DECOR', 'poly');

insert into region
values('Vase', '731,488,1138,568,1259,363', 'DECOR', 'poly');


insert into room_configuration
values('', '01');

insert into room_configuration
values('ChairLeft:3', '03');

insert into room_configuration
values('ChairRight:3', '02');

insert into room_configuration
values('BackWall:2,ChairRight:3', '05');

insert into room_configuration
values('ChairRight:3,LeftWall:2', '06');

insert into room_configuration
values('ChairRight:3,LeftWall:1', '07');

insert into room_configuration
values('BackWall:10,ChairRight:3,LeftWall:1', '08');

insert into room_configuration
values('BackWall:10,ChairRight:3,LeftCorner:4,LeftWall:1', '09');

insert into room_configuration
values('BackWall:10,ChairRight:3,LeftCorner:4,LeftWall:1,Rug:7', '10');

insert into room_configuration
values('BackWall:10,ChairRight:3,LeftCorner:4,LeftWall:1,RightCorner:8,Rug:7', '11');

insert into room_configuration
values('BackWall:10,ChairRight:3,LeftCorner:4,LeftWall:1,RightCorner:8,Rug:7,Vase:11', '13');

insert into room_configuration
values('BackWall:10,ChairRight:3,LeftCorner:4,LeftWall:1,Pillow:6,RightCorner:8,Rug:7,Vase:11', '14');

insert into room_configuration
values('BackWall:10,ChairRight:3,Frame:9,LeftCorner:4,LeftWall:1,Pillow:6,RightCorner:8,Rug:7,Vase:11', '15a')