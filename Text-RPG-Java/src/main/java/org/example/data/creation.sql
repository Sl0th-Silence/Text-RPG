# INSERT INTO prices (amount) VALUES
# (1),
# (2),
# (3),
# (5),
# (7),
# (10),
# (12),
# (15),
# (20),
# (25),
# (30),
# (50),
# (75),
# (100);

# INSERT INTO items (name, description, price_id)
# VALUES
#     ('Bucket', 'It\'s a bucket. What do you need to know?', 1),
#     ('Wrench', '"Lefty loosey, Righty tighty!"', 1),
#     ('Hammer', 'Hit things!', 1),
#     ('Screwdriver', 'You are so screwed.', 1),
#     ('Shovel', 'Are you digging a grave or planting a tree?', 1),
#     ('Chisel', 'For all your woodworking needs!', 1),
#     ('Wooden Spoon', 'I remember my childhood...', 1),
#     ('Tin Cup', 'Empty food container.', 1),
#     ('Rusty Key', 'Maybe it opens a lock?', 1),
#     ('Candle Stub', 'Your candle is no more!', 1),
#     ('Old Coin', 'If you clean this up, it may be worth a new coin!', 1),
#     ('Thread Spool', 'For goodness sakes, patch your pants already!', 1),
#     ('Bent Nail', 'Probably junk.', 1),
#     ('Cloth Scrap', 'Frayed and useless.', 1),
#     ('Empty Bottle', 'It used to contain the finer things!', 1),
#     ('Feather Quill', 'Do you want to write a memoire? No one will read it.', 1),
#     ('Small Mirror', 'AHH! Oh, it\'s only your reflection.', 1),
#     ('Worn Button', 'Do you need a button?', 1),
#     ('String Bundle', 'It\'s string.', 1),
#     ('Sealed Envelope', '...maybe you should open it?', 1),
#     ('Glass Marble', 'Shiny and round! Just like a monks head', 1),
#     ('Pocket Comb', 'Need a styling before your big date? Pocket Comb!', 1),
#     ('Ink Vial', 'Used with Quill for writing.', 1),
#     ('Tiny Bell', 'Shh, they can hear you coming!', 1);

CREATE TABLE phrase_type(
                            id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                            type TEXT
);

CREATE TABLE inputs(
                       id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                       phrase TEXT,
                       phrase_type_id INT,
                       FOREIGN KEY (phrase_type_id) references phrase_type(id)
);

# INSERT INTO phrase_type(type) VALUES
# ('greeting'),
# ('farewell'),
# ('initiate fight'),
# ('retreat fight'),
# ('help_commands'),
# ('general_commands'),
# ('movement_commands');

