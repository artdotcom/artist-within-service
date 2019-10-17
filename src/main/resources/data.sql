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
values('defaultRoom', '', 'Table,Frame,ChairLeft,ChairRight');


insert into region
values('Table', '200, 555, 300, 555, 175, 650, 75, 650', 'TABLE', 'poly');

insert into region
values('ChairLeft', '342,335,720,800', 'CHAIR', 'rect');

insert into region
values('ChairRight', '880,330,1280,820', 'CHAIR', 'rect');

insert into region
values('Frame', '700, 286, 500, 0', 'ART', 'rect');


insert into room_configuration
values('', '01');

insert into room_configuration
values('ChairLeft:3', '03');

insert into room_configuration
values('ChairRight:3', '02');