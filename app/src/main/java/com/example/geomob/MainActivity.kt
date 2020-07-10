package com.example.geomob

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import  com.example.geomob.data.AppDatabase
import com.example.geomob.data.Country
import com.example.geomob.data.CountryDao
import com.example.geomob.data.Images
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_countries.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.rv_countries
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() , ListAdapter.OnClickListner {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_countries.layoutManager = LinearLayoutManager(this)
        val dbDao = AppDatabase.invoke(this).getCountryDao()

        doAsync {

            val countries = dbDao.getInitialCountries()

            Log.e("Countries", countries.toString())

            uiThread {

                if (countries != null) refresh(countries)
            }

        }

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = preferences.edit()

         val filled = preferences.getBoolean("filled" ,false)

       //if ( !filled ) {

            doAsync {

                val gson = Gson()



                val images = arrayListOf<String> (
                "https://live.staticflickr.com//883//41011712220_16c0b8d1dd_o.jpg",
                "https://live.staticflickr.com//65535//50047590221_2ed512c68b_o.jpg",
                "https://live.staticflickr.com//65535//50058612772_322612ac4a_o.jpg")
                val imagesString = gson.toJson(images, Images::class.java)

                val videos = arrayListOf<String> (
                    "android.resource://" + getPackageName() + "/" + R.raw.canada1,
                    "android.resource://" + getPackageName() + "/" + R.raw.canada2
                 )
                val videosString = gson.toJson(videos, Images::class.java)

                val images2 = arrayListOf<String> (
                "https://live.staticflickr.com//65535//49934245137_95e8a57db4_o.jpg",
                "https://live.staticflickr.com//65535//47786357701_ac67259271_o.jpg",
                "https://live.staticflickr.com//65535//48924690721_6176ef5679_o.jpg")
                val imagesString2 = gson.toJson(images2, Images::class.java)

                val videos2 = arrayListOf<String> (
                    "android.resource://" + getPackageName() + "/" + R.raw.germany1,
                    "android.resource://" + getPackageName() + "/" + R.raw.germany2
                )
                val videosString2 = gson.toJson(videos2, Images::class.java)

                val images3 = arrayListOf<String> (
                "https://live.staticflickr.com//65535//49865878512_83e9e9b5f0_o.jpg",
                "https://live.staticflickr.com//4465//26206536459_7670e22b0d_o.jpg",
                "https://live.staticflickr.com//4888//40059791363_b12a2f2b5b_o.jpg")
                val imagesString3 = gson.toJson(images3, Images::class.java)

                val videos3 = arrayListOf<String> (
                    "android.resource://" + getPackageName() + "/" + R.raw.japan1,
                    "android.resource://" + getPackageName() + "/" + R.raw.japan2
                )
                val videosString3 = gson.toJson(videos3, Images::class.java)

                val images4 = arrayListOf<String> (
                "https://live.staticflickr.com//65535//49338150737_dbd136234d_o.jpg",
                "https://live.staticflickr.com//65535//49963189147_a8eb6d70d1_o.jpg",
                "https://live.staticflickr.com//65535//48868770336_d52d0fe877_o.jpg")
                val imagesString4 = gson.toJson(images4, Images::class.java)

                val videos4 = arrayListOf<String> (
                    "android.resource://" + getPackageName() + "/" + R.raw.australia1,
                    "android.resource://" + getPackageName() + "/" + R.raw.austraila2
                )
                val videosString4 = gson.toJson(videos4, Images::class.java)

                val images5 = arrayListOf<String> (
                "https://live.staticflickr.com//65535//50060938702_624549a487_o.jpg",
                "https://live.staticflickr.com//4138//4934202695_de91074a0a_o.jpg",
                "https://live.staticflickr.com//65535//50061241773_ce2b9bf1ac_o.jpg")
                val imagesString5 = gson.toJson(images5, Images::class.java)

                val videos5 = arrayListOf<String> (
                    "android.resource://" + getPackageName() + "/" + R.raw.uk1,
                    "android.resource://" + getPackageName() + "/" + R.raw.uk2
                )
                val videosString5 = gson.toJson(videos5, Images::class.java)


            var country1 =
                Country ("ca" ,
                    "Canada",
                    "https://www.countryflags.io/ca/flat/64.png",
                    "https://upload.wikimedia.org/wikipedia/commons/2/2c/%22O_Canada%22%2C_" +
                            "performed_by_the_United_States_Third_Marine_Aircraft_Wing_Band.oga",
                    "Ottawa",
                    "9,984,670 km2",
                    "37,971,020",
                    "Canada is a country in the northern part of North America. Its ten provinces and three " +
                            "territories extend from the Atlantic to the Pacific and northward into the Arctic Ocean," +
                            " covering 9.98 million square kilometres (3.85 million square miles), making it the world's " +
                            "second-largest country by total area." ,
                    "The history of Canada covers the period from the arrival of the " +
                            "Paleo-Indians thousands of years ago to the present day. Prior to European colonization, " +
                            "the lands encompassing present-day Canada were inhabited for millennia by Indigenous peoples, " +
                            "with distinct trade networks, spiritual beliefs, and styles of social organization. Some of these" +
                            " older civilizations had long faded by the time of the first European arrivals and have been " +
                            "discovered through archeological investigations." +
                            "Starting in the late 15th century, French and British expeditions explored," +
                            " colonized, and fought over various places within North America in what constitutes " +
                            "present-day Canada. The colony of New France was claimed in 1534 with permanent settlements " +
                            "beginning in 1608. France ceded nearly all its North American possessions to the United Kingdom " +
                            "in 1763 after the French defeat in the Seven Years' War. The now British Province of Quebec was" +
                            " divided into Upper and Lower Canada in 1791 and reunified in 1841. In 1867, the Province of " +
                            "Canada was joined with two other British colonies of New Brunswick and Nova Scotia through" +
                            " Confederation, forming a self-governing entity named Canada. The new country expanded by" +
                            " incorporating other parts of British North America, finishing with Newfoundland and Labrador in 1949." +
                            "\n" +
                            "Although responsible government had existed in Canada since 1848, Britain continued to set " +
                            "its foreign and defence policies until the end of the First World War. The passing of the Statute of " +
                            "Westminster in 1931 recognized that Canada had become co-equal with the United Kingdom. After the" +
                            " Constitution was patriated in 1982, the final vestiges of legal dependence on the British parliament" +
                            " were removed. Canada currently consists of ten provinces and three territories and is a parliamentary " +
                            "democracy and a constitutional monarchy with Queen Elizabeth II as its head of state.\n" +
                            "\n" +
                            "Over centuries, elements of Indigenous, French, British and more" +
                            " recent immigrant customs have combined to form a Canadian culture that has also been " +
                            "strongly influenced by its linguistic, geographic and economic neighbour, the United States. " +
                            "Since the conclusion of the Second World War, Canadians have supported multilateralism abroad and socioeconomic " +
                            "development." ,
                         imagesString  ,
                    "",
                    videosString
                    )
                var country2 =
                Country ("de" ,
                    "Germany",
                    "https://www.countryflags.io/de/flat/64.png",
                    "https://upload.wikimedia.org/wikipedia/commons/a/a6/German_national_anthem_performed_by_the_US_Navy_Band.ogg",
                    "Berlin",
                    "357,022 km2",
                    "83,166,711",
                    "Germany is a Western European country with a landscape of forests, rivers, mountain ranges and North Sea beaches. It has over 2 millennia of history. Berlin, its capital, is home to art and nightlife scenes, the Brandenburg Gate and many sites relating to WWII. Munich is known for its Oktoberfest and beer halls, including the 16th-century Hofbräuhaus. Frankfurt, with its skyscrapers, houses the European Central Bank.\n" ,
                    "Ununited Germany.\n" +
                            "In its long history, Germany has rarely been united. For most of the two millennia that Central Europe has been inhabited by German-speaking peoples, such as the Eastern Franks, the area now called Germany was divided into hundreds of states, many quite small, including duchies, principalities, free cities, and ecclesiastical states. Not even the Romans united what is now known as Germany under one government; they managed to occupy only its southern and western portions. In A.D. 800 Charlemagne, who had been crowned Holy Roman emperor by Pope Leo III, ruled over a territory that encompassed much of present-day Belgium, France, Germany, the Netherlands, and Switzerland, but within a generation its existence was more symbolic than real.\n" +
                            "\n" +
                            "Medieval Germany\n" +
                            "Medieval Germany was marked by division. As France and England began their centuries-long evolution into united nation-states, Germany was racked by a ceaseless series of wars among local rulers. The Habsburg Dynasty's long monopoly of the crown of the Holy Roman Empire provided only the semblance of German unity. Within the empire, German princes warred against one another as before. The Protestant Reformation deprived Germany of even its religious unity, leaving its population Roman Catholic, Lutheran, and Calvinist. These religious divisions gave military strife an added ferocity in the Thirty Years' War (1618–48), during which Germany was ravaged to a degree not seen again until World War II.\n" +
                            "\n" +
                            "Peace of Westphalia\n" +
                            "The Peace of Westphalia of 1648 left German-speaking Europe divided into hundreds of states. During the next two centuries, the two largest of these states—Prussia and Austria—jockeyed for dominance. The smaller states sought to retain their independence by allying themselves with one, then the other, depending on local conditions. From the mid-1790s until Prussia, Austria, and Russia defeated Napoleon at the Battle of Leipzig in 1813 and drove him out of German territory, much of the area was occupied by French troops. Napoleon's officials abolished numerous small states; as a result, in 1815, after the Congress of Vienna, German territory consisted of only about 40 states.\n" +
                            "\n" +
                            "Revolutions for Unification and Democracy\n" +
                            "During the next half-century, pressures for German unification grew. Scholars, bureaucrats, students, journalists, and businessmen agitated for a united Germany that would bring with it uniform laws and a single currency and that would replace the benighted absolutism of petty German states with democracy. The revolutions of 1848 seemed at first likely to realize this dream of unity and freedom, but the monarch who was offered the crown of a united Germany, King Friedrich Wilhelm IV of Prussia, rejected it. The king, like the other rulers of Germany's kingdoms, opposed German unity because he saw it as a threat to his power.\n" +
                            "\n" +
                            "Otto von Bismarck\n" +
                            "Despite the opposition of conservative forces, German unification came more than two decades later, in 1871, following the Franco-Prussian War, when Germany was unified and transformed into an empire under Emperor Wilhelm I, king of Prussia. Unification was brought about not by revolutionary or liberal forces but rather by a conservative Prussian aristocrat, Otto von Bismarck. Sensing the power of nationalism, Bismarck sought to use it for his own aims, the preservation of a feudal social order and the triumph of his country, Prussia, in the long contest with Austria for preeminence in Germany. By a series of masterful diplomatic maneuvers and three brief and dazzlingly successful military campaigns, Bismarck achieved a united Germany without Austria. He brought together the so-called \"small Germany,\" consisting of Prussia and the remaining German states, some of which had been subdued by Prussian armies before they became part of a Germany ruled by a Prussian emperor.\n" +
                            "\n" +
                            "Prussian hegemony\n" +
                            "Although united Germany had a parliament, the Reichstag, elected through universal male suffrage, supreme power rested with the emperor and his ministers, who were not responsible to the Reichstag. The Reichstag could contest the government's decisions, but in the end the emperor could largely govern as he saw fit. Supporting the emperor were the nobility, large rural landowners, business and financial elites, the civil service, the Protestant clergy, and the military. The military, which had made unification possible, enjoyed tremendous prestige. These groups were pitted against the Roman Catholic Center Party, the Socialist Party, and a variety of liberal and regional political groups opposed to Prussia's hegemony over Germany. In the long term, Bismarck and his successors were not able to subjugate this opposition. By 1912 the Socialists had come to have the largest number of representatives in the Reichstag. They and the Center Party made governing increasingly difficult for the empire's conservative leadership.\n" +
                            "\n" +
                            "The World Wars\n" +
                            "In World War I (1914–18), Germany’s aims were annexationist in nature and foresaw an enlarged Germany, with Belgium and Poland as vassal states and with colonies in Africa. However, Germany’s military strategy, involving a two-front war in France and Belgium in the west and Russia in the east, ultimately failed. Germany’s defeat in 1918 meant the end of the German Empire. The Treaty of Versailles, the peace settlement negotiated by the victors (Britain, France, and the United States) in 1919, imposed punitive conditions on Germany, including the loss of territory, financial reparations, and a diminished military. These conditions set the stage for World War II.\n" +
                            "\n" +
                            "Weimar Republic\n" +
                            "A republic, the Weimar Republic (1919–33), was established with a constitution that provided for a parliamentary democracy in which the government was ultimately responsible to the people. The new republic's first president and prime minister were convinced democrats, and Germany seemed ready at last to join the community of democratic nations. But the Weimar Republic ultimately disappointed those who had hoped it would introduce democracy to Germany. By mid-1933 it had been destroyed by Adolf Hitler, its declared enemy since his first days in the public arena. Hitler was a psychopath who sensed and exploited the worries and resentments of many Germans, knew when to act, and possessed a sure instinct for power. His greatest weapon in his quest for political power, however, was the disdain many Germans felt for the new republic.\n" +
                            "\n" +
                            "Many Germans held the Weimar Republic responsible for Germany's defeat in World War I. At the war's end, no foreign troops stood on German soil, and military victory still seemed likely. Instead of victory, however, in the view of many, the republic's Socialist politicians arranged a humiliating peace. Many Germans also were affronted by the spectacle of parliamentary politics. The republic's numerous small parties made forming stable and coherent coalition governments very difficult. Frequent elections failed to yield effective governments. Government policies also often failed to solve pressing social and economic problems.\n" +
                            "\n" +
                            "Hitler as chancellor\n" +
                            "A modest economic recovery from 1924 to 1929 gave the Weimar Republic a brief respite. The severe social stress engendered by the Great Depression, however, swelled the vote received by extreme antidemocratic parties in the election of 1930 and the two elections of 1932. The government ruled by emergency decree. In January 1933, leading conservative politicians formed a new government with Hitler as chancellor. They intended to harness him and his party (the National Socialist German Workers’ Party, or Nazis), now the country's largest, to realize their own aim of replacing the republic with an authoritarian government. Within a few months, however, Hitler had outmaneuvered them and established a totalitarian regime. Only in 1945 did a military alliance of dozens of nations succeed in deposing him, and only after his regime and the nation it ruled had committed crimes of unparalleled enormity known as the Holocaust.\n" +
                            "\n" +
                            "The Postwar Era and Unification\n" +
                            "In the aftermath of World War II (1939–45) and following occupation by the victorious powers (the United States, the Soviet Union, Britain, and France), Germany came to consist of two states. One, East Germany, never attained real legitimacy in the eyes of its citizens, fell farther and farther behind economically, and had to use force to prevent its population from fleeing to the West. The other, West Germany, was resoundingly successful. Within two decades of defeat, it had become one of the world's richest nations, with a prosperity that extended to all segments of the population. The economy performed so successfully that eventually several million foreigners came to West Germany to work as well. West German and foreign workers alike were protected from need arising from sickness, accidents, and old age by an extensive, mostly nongovernment welfare system. In 1990 German unification overcame the geographic separation of the two German states, including an infamous wall between West Berlin and East Berlin, but economic integration still has not been achieved satisfactorily. In the first decade of the twenty-first century, the forces of globalization are posing a renewed challenge to the social-market economy in place throughout the nation.\n" ,
                    imagesString2  ,
                    "",
                    videosString2
                )
                var country3 =
                Country ("jp" ,
                    "Japan",
                    "https://www.countryflags.io/jp/flat/64.png",
                    "https://upload.wikimedia.org/wikipedia/commons/a/a3/Kimi_ga_Yo_instrumental.ogg",
                    "Tokyo",
                    "377,975 km2",
                    "125,930,000",
                    "Japan is an island country in East Asia located in the northwest Pacific Ocean. It borders the Sea of Japan to the west, and it extends from the Sea of Okhotsk in the north to the East China Sea and Taiwan in the south." ,
                    "ANCIENT JAPAN\n" +
                            "The First Japanese\n" +
                            "Human beings have lived in Japan for at least 30,000 years. During the last ice age, Japan was connected to mainland Asia by a land bridge and stone age hunters were able to walk across. When the ice age ended about 10,000 BC Japan became a group of islands.\n" +
                            "\n" +
                            "About 8,000 BC the ancient Japanese learned to make pottery. The period from 8,000 BC to 300 BC is called the Jomon. The word Jomon means 'cord marked' because those people marked their pottery by wrapping a cord around it. The Jomon people lived by hunting, fishing and collecting shellfish. The Jomon made tools of stone, wood, and bone. They also made clay figurines of people and animals called dogu.\n" +
                            "\n" +
                            "Between 300 BC and 300 AD a new era began in Japan. At that time the Japanese learned to grow rice. They also learned to make tools of bronze and iron. The Japanese also learned to weave cloth.\n" +
                            "\n" +
                            "This period is called Yayoi. (It was named after a village called Yayoicho). Farming meant a more settled lifestyle. Yayoi people lived in villages of wooden huts. Farming and other skills also meant society became divided into classes. The leaders of Yayoi society were buried in mounds away from the ordinary people's burial grounds.\n" +
                            "\n" +
                            "The Kofun Period in Japan\n" +
                            "The Yayoi period was followed by the Kofun (from 300 AD to 710 AD). At this time Japan gradually became united. The rich and powerful men of the era were buried in vast tombs called Kofun. Clay figures called haniwa were placed around the tombs to guard them. At that time Japan was heavily influenced by China. About 400 AD writing was introduced into Japan from China. The Japanese also learned to make paper from the Chinese. They also learned to make porcelain, silk, and lacquer. The Japanese also learned to plan cities in the Chinese way.\n" +
                            "\n" +
                            "According to tradition in 552 AD the king of Paekche in Korea sent priests to convert Japan to Buddhism. The native Japanese religion is called Shinto, which means 'the way of the gods'. Shinto teaches that spirits are present everywhere in nature. Every natural phenomenon such as a mountain, lake, tree, waterfall and even rock has a spirit. Shinto does not have prophets or a sacred book but its teachings were passed on in myths. Shinto has many ceremonies and festivals. The two religions, Buddhism and Shinto co-existed peacefully in Japan. Shinto is more concerned with this life and its followers frequently pray for things they need or desire. Buddhism is more concerned with what happens after death. Most of the Japanese were happy to practice both religions.\n" +
                            "\n" +
                            "Furthermore in the 7th century AD the emperor became more powerful. Prince Shotoku (574-622) ruled as regent to Empress Suiko. He was a patron of the arts and learning. He brought scholars from China and Korea to Japan and he adopted the Chinese calendar.\n" +
                            "\n" +
                            "Shotoku also built the Horyuji Buddhist temple and monastery in 607. It burned down in 670 but it was rebuilt and became a center of Buddhist learning. Today they are the world's oldest surviving wooden structures.\n" +
                            "\n" +
                            "After him, in 646, a series of reforms were made known as the Taika. From then on all land in Japan belonged to the emperor. Peasants were made to pay taxes to the emperor either in goods like rice or cloth or in labor by working on building sites or by serving as soldiers. In 670 a census was held to find out how many taxpayers there were. By the late 7th century Japan was a centralized and highly civilized kingdom.\n" +
                            "\n" +
                            "At that time the capital of Japan was moved when an emperor died as people believed it was unlucky to stay in the same place afterwards. However, following the Chinese custom, the Japanese decided to create a permanent capital. They built a city at Nara in 710. At that time Japan was divided into provinces. In 713 the governor of each Japanese province was ordered to write a report about his province. The reports described the products of each province as well as its plants, animals and other resources.\n" +
                            "\n" +
                            "However in the 8th century Buddhist monks and priests began to interfere in politics. So in 784 Emperor Kammu (737-806) decided to move his capital. Eventually, in 794 he moved to Heian-Kyo, which means 'capital of peace'. Later the city's name changed to Kyoto and it remained the official capital of Japan till 1868.\n" +
                            "\n" +
                            "The Heian Period in Japan\n" +
                            "The era from 794 to 1185 is called the Heian period. During this period the arts and learning flourished. About 1000 Ad Lady Murasaki Shikibu wrote the world's first novel The Tale of Genji a story about the life of a prince called Genji. Another book from that time is a diary written by a lady in waiting named Sei Shonagon. It is called The Pillow Book.\n" +
                            "\n" +
                            "Meanwhile at the beginning of the 9th century Dengo Daishi founded the Tendai sect of Buddhism. Slightly later Kobo Daishi founded the Shingon sect. Meanwhile, in the late 7th century, an aristocratic family called the Fujiwara became very powerful. They had an increasing influence on Japanese politics.\n" +
                            "\n" +
                            "Moreover outside Kyoto the emperor's power grew weaker. Rich landowners became increasingly powerful and they employed private armies. (Japanese warriors were called Samurai). In feudal Japan, the Samurai were hereditary warriors who followed a code of behavior called bushido. Samurai were supposed to be completely loyal and self-disciplined. Rather than be captured by the enemy samurai were supposed to commit suicide by disemboweling themselves. This was called seppuku. Samurai fought with long swords called katana and short swords called wakizashi. They also used spears called yari and daggers called tanta. Samurai also had skewers called kogai and small knives called kozuka.\n" +
                            "\n" +
                            "The main piece of armor to protect a the torso was called a haramaki. It had skirts called kaskazuri to protect the lower torso. A helmet was called a kabuto. A kabuto had neck guards called shikoro. It sometimes had a crest called a kaijirushi. The neck was also protected by a piece called the nowdawa. Samurai also wore masks called mempo. They wore armored sleeves called kote to protect their arms.\n" +
                            "\n" +
                            "Eventually in 1180 civil war broke out between rival powerful families in Japan. On one side were the Taira family (also called the Heike). On the other side were the Minamoto family (also called the Genepi). The Minamoto were supported by the Fujiwara. They were led by two brothers Yoritomo and Yoshitsune. The Taira were finally defeated by the Minamoto in a naval battle at Dannoura in 1185.\n" +
                            "\n" +
                            "JAPAN IN THE MIDDLE AGES\n" +
                            "In 1192 the emperor gave Yoritomo the title Sei Tai Shogun, which means barbarian conquering great general. The shogun became the real power in Japan ruling in the emperor's name. This new form of government was called bakufu, which means tent government as generals gave commands from their tents during wartime.\n" +
                            "\n" +
                            "After Yoritomo's death two of his sons ruled Japan in turn. However, the second son was assassinated in 1219. Power then passed to Yoritomo's wife's family, the Hojo. Afterward, Japan had an emperor, who was only a figurehead, a Shogun and a Hojo regent ruling on behalf of the shogun.\n" +
                            "\n" +
                            "In the 13th and 14th centuries town and trade in Japan grew and merchants became wealthy. They organized themselves into guilds. Also at this time, Zen Buddhism became popular. Zen emphasizes meditation. Some followers meditate by trying to empty their minds of all worldly thoughts and desires. Others meditate on riddles called Koan such as 'what is the sound of one hand clapping?'. Zen had a tremendous influence on the arts like gardening and flower arranging. (Japanese flower arranging is called Ikebana and from the 15th century it developed into a sophisticated art).\n" +
                            "\n" +
                            "Also at this time the tea ceremony evolved in Japan. According to tradition, a monk named Eisai (1141-1215) brought tea seeds from China in 1191. He believed that tea helped monks remain alert when they were meditating. To maintain the calm mood the tea was prepared slowly and carefully. Gradually the process of making and drinking tea in a peaceful and relaxing environment spread to the nobility and merchants. Finally, in the late 16th century the tea ceremony or cha-no-yu was developed into its modern form by Sen no Rikyu (1522-1519).\n" +
                            "\n" +
                            "In the middle of this era the Mongols tried to conquer Japan. They sent fleets in 1274 and 1281. In 1274 the Mongols landed but withdrew when their fleet was endangered by a storm. In 1281 the Mongols landed again. For seven weeks they held a bridgehead in Japan but again their fleet was scattered by a typhoon. The Japanese called it Kamikaze, which means divine wind.\n" +
                            "\n" +
                            "Fighting the Mongols cost a great deal of money. That, in turn, meant high taxes and inevitably the government became deeply unpopular. Meanwhile, the emperor Go-Daigo was not content to be a mere figurehead and in 1333 he raised an army to fight the Hojo. The Hojos sent a force under a general named Ashikaga Takauji (1305-1358). However, Takauji changed sides. He joined forces with Emperor Go-Daigo and the Hojos committed suicide. However, Go-Daigo and Ashikaga Takauji soon quarreled. In 1336 Takauji led a rebellion. Go-Daigo fled to Yoshino. Takauji created a rival emperor in Kyoto and ruled as shogun. So until 1392, Japan had two emperors.\n" +
                            "\n" +
                            "The Muromachi Period in Japan\n" +
                            "The era from 1333 to 1573 is called the Muromachi period because the Ashikaga family ruled from the Muromachi district of Kyoto. During the Muromachi period, Noh theater developed in Japan. Actors were masks and perform on a bare stage with a painted backdrop. Musicians accompany the actors.\n" +
                            "\n" +
                            "Furthermore two great monuments survive from the Muromachi period, the Kinkaku-ji and the Ginkaku-ji, (gold and silver pavilions) in Kyoto.\n" +
                            "\n" +
                            "However in 1466 the Ashikaga family argued over who would be the next Shogun. The argument became the Onin War from 1467-1477. The fighting took place mostly in and around Kyoto and much of the city was destroyed. By the end of the 15th century central authority had virtually disappeared. While there was still an emperor he was only a figurehead and Japan was afflicted by a long series of civil wars as rival landowners, called daimyos, fought for power.\n" +
                            "\n" +
                            "The Portuguese arrive in Japan\n" +
                            "In 1542 the Portuguese arrived in Japan. Two Portuguese were passengers on a Chinese ship that landed at Tanegashima Island. The Portuguese were keen to trade with the Japanese and they soon returned. Very quickly the Japanese learned to make guns from the Portuguese. The Portuguese also brought tobacco and sweet potatoes to Japan. They also brought clocks. The Japanese called the Portuguese namban, which means southern barbarians because they sailed to Japan from the south.\n" +
                            "\n" +
                            "In 1549 Jesuit missionaries led by Francis Xavier arrived in Japan and attempted to convert the Japanese to Roman Catholicism. At first, the Japanese tolerated them. In 1571 Nagasaki was founded to trade with the Europeans and it became a center of missionary activity.\n" +
                            "\n" +
                            "Meanwhile Japanese warfare was radically changed by the introduction of handguns and cannons. A warlord called Oda Nobunaga quickly learned to use the new weapons and in 1569 he captured the port of Sakai. In 1575 he won a great victory at Nagashino. By the time he died in 1582 he controlled central Japan.\n" +
                            "\n" +
                            "Oda Nobunaga was assassinated in 1582 but his general Toyotomi Hideyoshi (1536-1598) avenged his death and continued the work of reuniting Japan. In 1587 he subdued the southern island of Kyushu and by 1590 he had also conquered eastern Japan. Toyotomi then attempted to conquer Korea. However, he failed and the Japanese withdrew in 1598. Toyotomi died shortly afterward.\n" +
                            "\n" +
                            "Toyotomi wanted his son Hideyori to succeed him. Before he died Toyotomi persuaded his general Tokugawa Ieyasu (1543-1616) to promise to support his son. However, Ieyasu soon broke his promise and seized power for himself. In 1600 he crushed his rivals at Sekigahara although Hideyori survived. In 1603 Ieyasu was made shogun and in 1615 his forces captured Osaka castle, the stronghold of Hideyori. Hideyori killed himself. Japan was now united under a strong central government and the Tokugawa family ruled as shoguns until 1868.\n" +
                            "\n" +
                            "The Tokugawa Period in Japan\n" +
                            "\n" +
                            "During the Tokugawa period Japanese society was strictly divided. At the top were the daimyo, the landowners. Below them were the samurai, hereditary warriors. Below them came the farmers, the craftsmen than the merchants. (The merchants were at the bottom because they did not make anything. However, in reality, many merchants became very rich).\n" +
                            "\n" +
                            "Meanwhile in 1600 a badly damaged Dutch ship landed in Japan. On board was an Englishman, William Adams (1564-1620). He was taken to Ieyasu, who questioned him. Adams showed the Japanese how to build two European style ships. He also married a Japanese woman and lived in Japan until his death.\n" +
                            "\n" +
                            "In 1609 another Dutch ship arrived in Japan. The shogun granted the Dutch the right to trade with Japan. In 1613 an English ship came the shogun gave them to the right to trade. Meanwhile, Japanese merchants sailed to Thailand and the Philippines (a Spanish colony). In 1610 a Japanese merchant called Tanaka Shosuke sailed to Mexico.\n" +
                            "\n" +
                            "However despite trading with foreigners the Japanese began persecuting Christians. The government feared Christians were a threat to Japan's internal security. In 1597 Toyotomi Hideyoshi had 26 Christians including 9 European missionaries, crucified in Nagasaki. In 1612 Christianity was banned altogether in Japan and persecution of Christians grew worse and worse. Finally in 1637 Christians in the Shimabara area rebelled. However, in 1638 the rebellion was crushed and Christians were massacred.\n" +
                            "\n" +
                            "The Japanese government then shut their country off from the rest of the world. Between 1633 and 1639 laws were passed forbidding the Japanese to travel abroad or to build ocean-going ships. Only the Chinese and the Dutch were allowed to trade with Japan. In 1641 the Dutch were restricted to an island in Nagasaki Harbor called Dejima. This policy of isolating Japan was called sakoku. However, Japan did not cut itself off from the outside world completely. Dutch books were still imported and the Japanese ruling class were quite well informed of what was happening in the outside world.\n" +
                            "\n" +
                            "The Tokugawa government went to great lengths to maintain order. They directly controlled about one-quarter of the land in Japan. Around their land, they gave estates to trusted daimyos. The land around the edges of Japan was given to their former enemies. The Tokugawa also employed spies to watch powerful families in Japan.\n" +
                            "\n" +
                            "The arts flourished during the Tokugawa period. So did trade and commerce. However, Japan was not entirely peaceful. There were many peasant rebellions. Nevertheless, samurai were less useful than in former times and many became ronin or samurai without masters.\n" +
                            "\n" +
                            "In the late 17th century Kabuki theater developed in Japan. Male actors play the female roles and actors are accompanied by music and singing. The martial art of kendo developed into its modern form in the late 18th century. It was derived from samurai training but practitioners use bamboo staves instead of swords.\n" +
                            "\n" +
                            "By 1853 the Western powers wanted Japan to open her market to their goods. The Americans also wanted to use Japan as a coaling station for steamships. So in July 1853 4 American ships commanded by Commodore Matthew Perry sailed into Japanese waters near Edo. Perry handed over a message asking for trading rights, coaling ports and protection for shipwrecked sailors. Perry warned he would return next year with a much larger force. He returned in February 1854 with 9 ships.\n" +
                            "\n" +
                            "Japan's armed forces were in no state to resist so the shogun agreed to open two ports to American ships. By 1856 France, Britain, the Netherlands and Russia had also forced Japan to sign similar treaties. In 1858 the Americans forced the Japanese to open more ports to trade. Britain, France, and Russia forced Japan to sign similar treaties. The treaties stated that the Japanese could only charge low import duties on imported goods. Furthermore, foreign citizens were exempt from Japanese law.\n" +
                            "\n" +
                            "JAPAN IN THE LATE 19TH CENTURY\n" +
                            "\n" +
                            "The Meiji Restoration\n" +
                            "\n" +
                            "Not surprisingly the humiliating treaties were bitterly resented by the Japanese who called them unequal treaties. Furthermore, the shogun lost face because of his weakness. Many Japanese thought that Japan would only be strong if the shogunate was abolished and the emperor was restored to power. Some Japanese wanted to resist the foreigners. Others wanted to copy western technology. Opinion was bitterly divided.\n" +
                            "\n" +
                            "Finally in 1868 there was a short civil war. Pro-emperor and pro-shogun forces clashed at Fushimi and the pro-emperor force won. Afterward, Emperor Meiji and his followers were determined to modernize Japan. And they succeeded. In an astonishingly short period of time, Japan was transformed from a primitive, agricultural country to a modern industrial one.\n" +
                            "\n" +
                            "The government encouraged industrialization with loans and grants. Soon many new industries such as shipbuilding were flourishing. In 1870 the first mechanized silk mill opened in Japan. Also in 1870, a telegraph was laid between Tokyo (as Edo was renamed) and Yokohama. A railway was built between them in 1872. Meanwhile in 1871 private armies kept by daimyos were abolished. Many samurai joined the new national army. The same year the first Japanese newspaper was published.\n" +
                            "\n" +
                            "In 1872 compulsory education was introduced in Japan. The same year conscription was introduced. In 1878 the Japanese army was reformed to be like the German army. The Japanese navy was modeled on the British navy. In 1873 Japan adopted the Western calendar. The same year a land tax was introduced and the emperor and empress began wearing Western clothes. In 1889 Emperor Meiji granted a constitution based on the German one. Japan gained a parliament called a diet but only a small minority of men were allowed to vote.\n" +
                            "\n" +
                            "However these rapid changes were not popular with everyone. In 1877 samurai led by Saigo Takamori (1827-1877) rebelled in Satsuma. A conscript army led by Marshal Yamagata crushed the rebellion. Afterward, the samurai lost their privileges and most were forced to take civilian jobs.\n" +
                            "\n" +
                            "In 1894 Japan and Korea quarreled over Korea. China regarded Korea as being under its 'influence' and in 1894 sent troops into that country. The Japanese objected and went to war. The Sino-Japanese war was a stunning victory for Japan. The Japanese quickly drove the Chinese out of Korea and captured Port Arthur. By the Treaty of Shimonoseki in 1895, Japan gained Formosa (Taiwan) and Port Arthur. China was also forced to pay a large indemnity and to refrain from interfering in Korean politics. However, Russia, France, and Germany forced Japan to give back Port Arthur.\n" +
                            "\n" +
                            "JAPAN IN THE EARLY 20TH CENTURY\n" +
                            "\n" +
                            "Then on 30 January 1902 Japan signed a treaty with Britain. Both agreed to help the other if they were attacked by two other countries. Meanwhile, Russia was increasing her influence in Manchuria, which brought her into conflict with Japan. On 9 February 1904, the Japanese navy sank two Russian ships at Port Arthur (Russia had leased this Chinese port in 1898). The Japanese then laid siege to Port Arthur but they took 5 months to capture it. Nevertheless, the Japanese army gradually advanced in Manchuria and on 27 May 1905, the Japanese navy won a complete victory at Tsushima. The Americans mediated between Russia and Japan and the two signed the Treaty of Portsmouth in September 1905. Japan gained Port Arthur and the southern part of Sakhalin. Japan also gained great prestige. She was the first Asian power to defeat a European power.\n" +
                            "\n" +
                            "Then in 1910 Japan annexed Korea. Furthermore, by 1911 all foreign countries had agreed to abolish the 'unequal treaties' of the 1850s. By the time Emperor Meiji died in 1912 Japan was a power to be reckoned with.\n" +
                            "\n" +
                            "When the First World War began Japan joined Britain's side. Japan took German colonies in Asia. However, after the war, Japan's growing economic and political power brought her into conflict with the USA.\n" +
                            "\n" +
                            "In 1921 the Washington Conference was held. Britain and the USA pressed Japan to accept a naval treaty. For every 5 tons of warship Britain and the USA had in the Pacific Ocean Japan was allowed 3. So the Western powers were determined to keep Japan in her place. Then on 1 September 1923, an earthquake devastated Tokyo. After the actual tremor fire swept through the city. about 107,000 people died. In 1924 Japan suffered another 'slap in the face' when the USA banned immigration from Japan.\n" +
                            "\n" +
                            "In 1926 Hirohito became emperor. In the first years of Hirohito's reign the Japanese economy did well but in 1929 the world entered a severe recession. Meanwhile, Japan had an army stationed in Manchuria around Port Arthur. The Japanese also controlled much of the Manchurian economy. The Japanese army thought Japan should take over Manchuria and in 1931 the army engineered a takeover. Japan controlled a railway running through Manchuria. On 18 September 1931, an explosion near Mukden damaged it. Japanese troops claimed they saw Chinese troops running away. The Japanese army then acted independently and seized Muckden. In December 1931 the army took over all of Manchuria. The Japanese government could not stop them.\n" +
                            "\n" +
                            "Meanwhile the Chinese emperor had been overthrown in 1911. In 1932 he was made puppet ruler of Manchuria, which was renamed Manchukuo. However, the real power in the region was the Japanese army. Japanese politicians were powerless to stop the generals.\n" +
                            "\n" +
                            "The Japanese army gradually took control of Japan. Civilian politicians were still the nominal rulers but the army held the real power. Politicians were too weak to resist them.\n" +
                            "\n" +
                            "Many in the army pressed for expansion into China. In 1936 China was forced to accept the Japanese occupation of an area of China called Fengtai near Beijing. The tension then grew between Japanese and Chinese troops in that region and on 7 July 1937 fighting broke out. Japan rushed troops to the area and soon it became a full-scale invasion of China, although there was no formal declaration of war. In December 1937 the Japanese captured Nanking and massacred civilians.\n" +
                            "\n" +
                            "Then in July 1941 Japanese troops occupied French Indo-China. The USA objected, fearing Japan was a threat to its interests in the Pacific. The USA banned exports of oil to Japan. Japan imported 80% of its oil from the USA and was faced with the choice between a humiliating climb-down and war. The Japanese chose war.\n" +
                            "\n" +
                            "Japan sent a force of aircraft carriers and on 7 December 1941 they attacked the US Pacific fleet at Pearl Harbor. The Japanese sank many ships but vitally they missed several American aircraft carriers that were at sea.\n" +
                            "\n" +
                            "At first the Japanese had amazing success. In February 1942 they captured Singapore the main British base in the Far East. In the months January to May 1942, they also captured the Philippines and most of Indonesia. However, the tide turned at the battle of Midway Island in May 1942 when they lost 4 aircraft carriers.\n" +
                            "\n" +
                            "In January-February 1943 the Japanese were forced to evacuate Guadalcanal and in August 1943 they were defeated by the Australians in New Guinea. Meanwhile, in June 1943 the Americans began submarine warfare and Japanese shipping suffered terrible losses. The Americans also began a campaign of 'island hopping'. They attacked certain Pacific Islands held by the Japanese and left others nearby to 'wither on the vine'. The Japanese suffered a severe naval defeat at Leyte Gulf in October 1944. Meanwhile, a British army from India pushed the Japanese back into Burma. In the end, Japan was defeated by the USA's overwhelming industrial strength.\n" +
                            "\n" +
                            "From March 1945 Japanese kamikaze pilots flew suicide missions, deliberately crashing into American ships. But it was to no avail. In June 1945 the Americans captured Okinawa. Meanwhile, the American bombing was destroying Japanese cities. On 26 July 1945 Truman and Churchill demanded Japan to surrender and threatened the Japanese with 'prompt and utter destruction' if they did not. Japan refused.\n" +
                            "\n" +
                            "On 6 August 1945 an American bomber, the Enola Gay, dropped an atomic bomb on Hiroshima. On 9 August another was dropped on Nagasaki.\n" +
                            "\n" +
                            "Japan capitulated on 15 August 1945. An official surrender document was signed on 2 September. Following the Japanese surrender, the Americans occupied Japan. General MacArthur led US troops. Under him, 7 Japanese war criminals were hanged including wartime Prime Minister Tojo Hideki.\n" +
                            "\n" +
                            "JAPAN IN THE LATE 20TH CENTURY\n" +
                            "\n" +
                            "The emperor publicly announced that he was not divine and in 1946 the Americans drew up a new constitution for Japan. Women were allowed to vote. The constitution also contained a clause renouncing the 'threat or use of force as a means of settling international disputes'. In 1951 a peace treaty was signed in San Francisco and the American occupation ended in 1952. However, the Treaty of Mutual Cooperation and Security gave the USA the right to keep bases in Japan. Furthermore, the island of Okinawa was occupied until 1972. Meanwhile, the Korean War began in 1950. It provided a boost to Japanese industry and by 1954 Japanese industrial production was back to 1939 levels.\n" +
                            "\n" +
                            "In 1955 the Liberal Democratic Party took power and it ruled Japan for most of the period from 1955 to 2009.\n" +
                            "\n" +
                            "Meanwhile during the 1950s and 1960s the Japanese economy boomed. Japanese industry exported huge numbers of electronic goods and vehicles. The Japanese people saw a great improvement in their standard of living. Rapid economic growth in Japan continued during the 1970s and 1980s while much of the rest of the world was mired in recession.\n" +
                            "\n" +
                            "However in the 1990s the period of rapid economic growth ended and a long recession began, although Japan remained a rich country. Worse in 1995 the city of Kobe was devastated by an earthquake. Meanwhile Emperor Hirohito died in 1989 and was succeeded by Emperor Akihito.\n" +
                            "\n" +
                            "JAPAN IN THE 21ST CENTURY\n" +
                            "\n" +
                            "In 2009 a major political change took place in Japan. The Liberal Democratic Party ruled Japan for all of the years 1995-2009 except for a period of 11 months. However in 2009 the Democratic Party of Japan won a majority in the lower house of parliament. Today Japan is a prosperous nation. Today the population of Japan is 127 million.\n" +
                            "\n" ,
                    imagesString3  ,
                    "",
                    videosString3
                )


                var country4 =
                Country ("au" ,
                    "Australia",
                    "https://www.countryflags.io/au/flat/64.png",
                    "https://upload.wikimedia.org/wikipedia/commons/a/a6/U.S._Navy_Band%2C_Advance_Australia_Fair_%28instrumental%29.ogg",
                    "Canberra",
                    "7,692,024 km2",
                    "25,756,900",
                    "Australia, officially the Commonwealth of Australia, is a sovereign country comprising the mainland of the Australian continent, the island of Tasmania, and numerous smaller islands. It is the largest country in Oceania and the world's sixth-largest country by total area." ,
                    "Who was here first?\n" +
                            "The original inhabitants of Australia were the Aborigines, who still remain today and who can claim more than 50 millennia of history here. In fact, Aborigines are the world’s oldest living cultural civilisation. Before the British colony was established, it is estimated that there were as many as one million Indigenous folks living in Australia.\n" +
                            "\n" +
                            "There were more than 500 regional groups, or tribes, from the Yapa, Yolngu and Bininj people in what is now the Northern Territory to the Palawah people in Tasmania and all across the land. Additionally, the people from the Torres Strait Islands are distinct from Aborigines but are still, today, considered Australians.\n" +
                            "\n" +
                            "See more at our pages on Aboriginal culture and Aboriginal festivals.\n" +
                            "\n" +
                            "Discovery by the British\n" +
                            "On 29th April 1770, the British explorer Captain James Cook stepped ashore in what is now Botany Bay in New South Wales. Cook and his crew encountered the local ‘Gweagal’ tribe of Aborigines and assumed that since they inhabited the shores, the interior of the land was uninhabited.\n" +
                            "\n" +
                            "They also assumed that the Aborigines would abandon their land and the British could explore it as the setting for a new British colony. Instead, the natives went about ambushing convicts who were sent to the bush to work. Known as ‘frontier massacres’, the battles began in 1789 and the Aborigines were no match for modern British weaponry.\n" +
                            "\n" +
                            "Hundreds of massacre sites have since been identified, many that occurred post-federation. To the current day, debate rages over whether Australia Day on 26th January – which celebrates the anniversary of the 1788 arrival of the First Fleet – should instead be marked as ‘Invasion Day’.\n" +
                            "\n" +
                            "Claiming ownership of Australia for England\n" +
                            "James Cook claimed ownership of Australia’s east coast for the British Crown in 1770 during his first voyage of the Pacific. His recommendation, upon returning to Britain, was that the new land become a penal colony.\n" +
                            "\n" +
                            "British prisons had become severely and unsustainably over-crowded due to poverty-related petty theft and Australia would become somewhat of an annexe for England. Plans were made to start sending convicts to Australia.\n" +
                            "\n" +
                            "Important migration periods in Australia’s history\n" +
                            "1770 – James Cook’s ship The Endeavour lands in Botany Bay.\n" +
                            "1788 – The First Fleet, commanded by Captain Arthur Phillip lands in Port Jackson. The Sydney Cove first colonial settlement is established.\n" +
                            "1788-1868 – Over this period, around 162,000 English, Irish, Welsh and Scottish convicts were transported to Australia.\n" +
                            "1801-1859 – Other major centres were discovered and established, including Melbourne, Fremantle/Perth, Adelaide, Van Diemen’s Land (Tasmania) and Queensland.\n" +
                            "1850s – Australia experienced a booming economy thanks, in large part, to the discovery of gold. These were the ‘gold rush’ years. Immigrants poured in from England, Ireland, Scotland, Wales, China, Germany and America.\n" +
                            "1901 – Federation! The six separate British colonies (Queensland, New South Wales, Victoria, Tasmania, South Australia and Western Australia) agreed to unite to form the Commonwealth of Australia. The country’s first ever Prime Minister, Edmund Barton was elected.\n" +
                            "1914-1918 – World War I. Australia became involved to support the mother country and suffered deep losses. Of the 416,809 men enlisted, more than 60,000 were killed.\n" +
                            "1927 – Canberra becomes the country’s new capital, taking the reins from Melbourne.\n" +
                            "1930 – The Great Depression sets in and Australia’s economy nosedives.\n" +
                            "1939-1945 – World War II. Australia’s involvement included 993,000 personnel from the defence forces. A total of 27,073 were killed in action or died.\n" +
                            "1945 – After World War II, Prime Minister Ben Chifley declared: “A powerful enemy looked hungrily toward Australia. We must populate Australia as rapidly as we can before someone else decides to populate it for us.” The Department of Immigration was established to aim for annual population growth of two percent, of which half should come from natural increase and the other half, from migrants. As many as 70,000 immigrants were needed annually to make up these numbers.\n" +
                            "1948 – The post-war migrant boom brought the famous ‘Ten Pound Pom’ to Australia for a 25-year period. Australia began to accept migrants from over 30 European nations and the largest numbers aside from the British came from Italy and Greece, until the early 1970s.\n" +
                            "1956 – Up until now, the Immigration Restriction Act 1901, aka ‘White Australia’ policy was in play to “keep Australia British”. This was relaxed in 1956, when non-European residents were permitted to apply for Australian citizenship.\n" +
                            "1973 – Minister for Immigration, Al Grassby – later known as Australia’s ‘Father of Multiculturalism’ presented an important paper: A Multi-cultural Society for the Future. Government programs and funds were used to shape a new ethnic identity for the country. The Grassby approach has been adopted by other western democracies for decades since.\n" +
                            "1975 – Australia’s first ‘boat people’ began arriving, refugees from East Timor, Vietnam, China and, in recent times, the Middle East.\n" +
                            "1980s – Australia’s immigration policy became focused on family visas and selecting migrants who matched Australia’s skills criteria.\n" +
                            "1981 – The ‘assisted passage scheme’ that helped migrants to settle in to Australia ended and only refugees were then provided with support.\n" +
                            "Late 1990s – The number of asylum seekers increased as people fleeing the Middle East and Sri Lanka arrived by boat.\n" +
                            "2006 – The refugee groups growing most rapidly are Sudanese, Afghans and Iraqis.\n" +
                            "Today – Since around 2012, Australia has welcomed around 190,000 permanent new arrivals a year. The humanitarian intake has sat at around 11-14,000 per year since the mid-1980s. Approximately 12,000 Syrians were accepted in 2015 in response to the war in Syria, and temporary arrivals such as international students and people entering on 457 work visas have numbered around 400,000.\n",
                    imagesString4  ,
                    "",
                    videosString4
                )

            var country5 =
                Country ("gb" ,
                    "United Kingdom",
                    "https://www.countryflags.io/gb/flat/64.png",
                    "https://upload.wikimedia.org/wikipedia/commons/d/de/United_States_Navy_Band_-_God_Save_the_Queen.ogg",
                    "London",
                    "242,495 km2",
                    "67,886,004",
                    "DescriptionThe United Kingdom, made up of England, Scotland, Wales and Northern Ireland, is an island nation in northwestern Europe. England – birthplace of Shakespeare and The Beatles – is home to the capital, London, a globally influential centre of finance and culture. England is also site of Neolithic Stonehenge, Bath’s Roman spa and centuries-old universities at Oxford and Cambridge." ,
                    "In the 5 century, the Romans progressively abandoned Britannia, as their Empire was falling apart and legions were needed to protect Rome.\n" +
                            "\n" +
                            "With the Romans vacated, the Celtic tribes started warring with each other again, and one of the local chieftains had the (not so smart) idea to request help from some of the Germanic tribes from the North of present-day Germany and South of Denmark. These were the Angles, Saxons and Jutes, who arrived in the 5th and 6th centuries.\n" +
                            "\n" +
                            "When the fighting ceased, the Germanic tribes did not, as expected by the Celts, return to their homeland.  In fact, they felt strong enough to seize the whole of the country for themselves, which they ultimately did, pushing back all the Celtic tribes to Wales and Cornwall, and founding their respective kingdoms of Kent (the Jutes), Essex, Sussex and Wessex (the Saxons), and further northeast, the kingdoms of Anglia, Mercia and Northumbria (the Angles). These 7 kingdoms, which ruled over the United Kingdom from about 500 to 850 AD, were later known as the Anglo-Saxon heptarchy.\n" +
                            "\n" +
                            "History of the United Kingdom:  The Vikings\n" +
                            "\n" +
                            "In the latter half of the 9 century, the Norse people from Scandinavia began to invade Europe, with the Swedes putting down roots in Eastern Europe and the Danes creating problems throughout Western Europe, as far as North Africa.\n" +
                            "\n" +
                            "Towards the dawn of the 10 century, the Danes invaded the Northeast of England, from Northumerland to East Anglia, and founded a new kingdom known as the Danelaw. Another group of Danes managed to take Paris, and obtain a grant of land from the King of France in 911. This area became the Duchy of Normandy, and its inhabitants were the Normans (from 'North Men' or 'Norsemen', another term for 'Viking').\n" +
                            "\n" +
                            "History of the United Kingdom: The Normans\n" +
                            "\n" +
                            "Depiction of Cnut the GreatAfter settling in to their newly acquired land, the Normans adopted the French feudal system and French as the official language.\n" +
                            "\n" +
                            "During that same period, the Kings of Wessex had resisted, and eventually vanquished the Danes in England in the 10th century.  However, the powerful Canute the Great (995-1035), king of the newly unified Denmark and Norway and overlord of Schleswig and Pomerania, led two other invasions on England in 1013 and 1015, and became king of England in 1016, after crushing the Anglo-Saxon King, Edmund II.\n" +
                            "\n" +
                            "During the 11 century, the Norman King Edward the Confessor (1004-1066) nominated William, Duke of Normandy, as his successor, but upon Edward’s death, Harold Godwinson, the powerful Earl of Wessex, crowned himself king. William refused to acknowledge Harold as King and invaded England with 12,000 soldiers in 1066.  King Harold was killed at the battle of Hastings and William the Conqueror become William I of England.\n" +
                            "\n" +
                            "The Norman rulers kept their possessions in France, and even extended them to most of Western France (Brittany, Aquitaine...). French became the official language of England, and remained that way until 1362, a short time after the beginning of the Hundred Years' War with France. English nevertheless remained the language of the populace, and the fusion of English (a mixture of Anglo-Saxon and Norse languages) with French and Latin (used by the clergy) slowly evolved into the modern English we know today.\n" +
                            "\n" +
                            "History of the United Kingdom:  12 and 13 Centuries\n" +
                            "\n" +
                            "The English royals that followed William I had the infamous habit to contend for the throne. William's son, William II was killed while hunting, although it is widely believed that he was in fact murdered so that William's second son, Henry, could become king. Henry I's succession was also fraught with agitation, with his daughter Matilda and her cousin Stephen (grandson of William I) starting a civil war for the throne. Although Stephen eventually won, it was ultimately Matilda's son that succeeded to the throne, becoming Henry II (1133-1189). It is under Henry II that the University of Oxford was established.\n" +
                            "\n" +
                            "The two children of Henry II—Richard I \"Lionhearted\" and John Lackland—also battled for the throne.  The oldest son, Richard, eventually succeeded to the throne, but because he was rarely in England, and instead off defending his French possessions or fighting the infidels in the Holy Land, his brother John Lackland usurped the throne and started another civil war.\n" +
                            "\n" +
                            "John's grandson, Edward I \"Longshanks\" (1239-1307) spent most of his 35-year reign fighting wars, including one against the Scots, led by William Wallace and Robert the Bruce.  With the help of these men, the Scots were able to resist, as immortalized in the Hollywood movie Braveheart.\n" +
                            "\n" +
                            "History of the United Kingdom:  14 and 15 Centuries\n" +
                            "\n" +
                            "After a brief rule by Edward Longshanks son, his grandson, Edward III (1312-1377), succeeded to the throne at the age of 15 and reigned for 50 years. His reign was marked by the beginning of the Hundred Years' War (1337-1416) and deadly epidemics of bubonic plague (\"Black Death\"), which killed one third of England’s (and Europe's) population.\n" +
                            "\n" +
                            "Edward III was often off fighting in France, leaving his third son, John of Gaunt, Duke of Lancaster, to run the government.  Later, John’s son, Henry Bolingbroke, would be proclaimed King Henry IV (1367-1413).\n" +
                            "\n" +
                            "Henry V (1387-1422) famously defeated the French at the Battle of Agincourt in 1415, but his pious and peace-loving son Henry VI (1421-1471), who inherited the throne at age one, was to have a much more troubled reign. The regent lost most of England’s possessions in France to a 17-year old girl (Joan of Arc) and in 1455 the Wars of the Roses broke out. This civil war opposed the House of Lancaster (the Red Rose, supporters of Henry VI) to the House of York (the White Rose, supporters of Edward IV). The Yorks argued that the crown should have passed to Edward III' second son, Lionel of Antwerp, rather than to the Lancaster descendant of John of Gaunt.\n" +
                            "\n" +
                            "Edward IV's son, Edward V, only reigned for one year, before being locked in the Tower of London by his evil uncle, Richard III (1452-1485).  In 1485, Henry Tudor (1457-1509), the half-brother of Henry VI, defeated Richard III at the Battle of Bosworth Field and became Henry VII, founder of the House of Tudor.\n" +
                            "\n" +
                            "Following Henry (Tudor) VII to the throne was perhaps England’s most famous and historically significant ruler, the magnificent Henry VIII (1491-1547).\n" +
                            "\n" +
                            "History of the United Kingdom:  16 Century\n" +
                            "\n" +
                            "Portrait of Henry VIIIHenry VIII is remembered in history as one of the most powerful kings of England. He changed the face of England, passing the Acts of Union with Wales (1536-1543), and became the first ruler to declare himself king of both Wales and Ireland.\n" +
                            "\n" +
                            "In 1533, Henry VIII divorced Catherine of Aragon to remarry Anne Boleyn, causing the Pope to excommunicate him from the church.  As a result, Henry proclaimed himself head of the Church of England. He dissolved all the monasteries in the country (1536-1540) and nationalized them, becoming immensely rich in the process.\n" +
                            "\n" +
                            "Henry VIII was the last English king to claim the title of King of France, as he lost his last possession there, the port of Calais (although he tried to recover it, taking Tournai for a few years, the only town in present-day Belgium to have been under English rule).\n" +
                            "\n" +
                            "It was also under Henry VIII that England started exploring the globe and trading outside Europe, although this would only develop to colonial proportions under his daughters, Mary I and especially Elizabeth I.\n" +
                            "\n" +
                            "Upon the death of Henry VIII, his 10-year old son, Edward VI, inherited the throne.  Six years later, however, Edward VI died and was succeeded by Henry’s elder half-daughter Mary. Mary I (1516-1558), a staunch Catholic, intended to restore Roman Catholicism to England, executing over 300 religious dissenters in her 5-year reign (which owned her the nickname of Bloody Mary). She married the powerful King Philip II of Spain, who also ruled over the Netherlands, the Spanish Americas and the Philippines (named after him), and was the champion of the Counterreformation.  Mary died childless of ovarian cancer in 1558, and her half-sister Elizabeth ascended to the throne.\n" +
                            "\n" +
                            "The great Queen Elizabeth I (1533-1603) saw the first golden age of England. It was an age of great navigators like Sir Francis Drake and Sir Walter Raleigh, and an age of enlightenment with the philosopher Francis Bacon (1561-1626), and playwrights such as Christopher Marlowe (1564-1593) and William Shakespeare (1564-1616).\n" +
                            "\n" +
                            "Her reign was also marked by conflicts with France and Scotland, and later Spain and Ireland. She never married, and when Mary Stuart tried and failed to take over the throne of England, Elizabeth kept her imprisoned for 19 years before finally signing her act of execution.\n" +
                            "\n" +
                            "Elizabeth died in 1603, and ironically, Mary Stuart's son, James VI of Scotland, succeeded Elizabeth as King James I of England—thus creating the United Kingdom.\n" +
                            "\n" +
                            "History of the United Kingdom:  17 Century\n" +
                            "\n" +
                            "James I (1566-1625), a Protestant, aimed at improving relations with the Catholic Church. But 2 years after he was crowned, a group of Catholic extremists, led by Guy Fawkes, attempted to place a bomb at the parliament's state opening, hoping to eliminate all the Protestant aristocracy in one fell swoop. However, the conspirators were betrayed by one of their own just hours before the plan's enactment. The failure of the Gunpowder Plot, as it is known, is still celebrated throughout Britain on Guy Fawkes' night (5th November), with fireworks and bonfires burning effigies of the conspirators' leader.\n" +
                            "\n" +
                            "After this incident, the divide between Catholics and Protestant worsened.  James's successor Charles I (1600-1649) was eager to unify Britain and Ireland.  His policies, however, were unpopular among the populace, and his totalitarian handling of the Parliament eventually culminated in the English Civil War (1642-1651).\n" +
                            "\n" +
                            "Charles was beheaded, and the puritan Oliver Cromwell (1599-1658) ruled the country as a dictator from 1649 to his death. He was briefly succeeded by his son Richard at the head of the Protectorate, but his political inability prompted the Parliament to restore the monarchy in 1660, calling in Charles I' exiled son, Charles II (1630-1685).\n" +
                            "\n" +
                            "Charles II, known as the “Merry Monarch,” was much more adept than his father at handling Parliament, although every bit as ruthless with other matters. During his reign, the Whig and Tory parties were created, and the Dutch colony of New Amsterdam became English and was renamed New York, after Charles' brother, James, Duke of York (and later James II).\n" +
                            "\n" +
                            "Charles II was the patron of the arts and science, helping to found the Royal Society and sponsoring some of England’s proudest architecture. Charles also acquired Bombay and Tangiers through his Portuguese wife, thus laying the foundation for the British Empire.\n" +
                            "\n" +
                            "Although Charles produced countless illegitimate children, his wife couldn't bear an heir, and when he died in 1685 the throne passed to his Catholic and unpopular brother James.\n" +
                            "\n" +
                            "James II's unpopularity led to his quick removal from power in the Glorious Revolution of 1688. He was succeeded by his Protestant daughter Mary, who was married to his equally Protestant nephew, William of Orange.\n" +
                            "\n" +
                            "The new ruling couple became known as the \"Grand Alliance,\" and parliament ratified a bill stating that all kings or queens would have to be Protestant from that point forward. After Mary's death in 1694, and then William's in 1702, James's second daughter, Anne, ascended to the throne. In 1707, the Act of Union joined the Scottish and the English Parliaments thus creating the single Kingdom of Great Britain and centralizing political power in London. Anne died heirless in 1714, and a distant German cousin, George of Hanover, was called to rule over the UK.\n" +
                            "\n" +
                            "History of the United Kingdom:  18 Century and the House of Hanover\n" +
                            "\n" +
                            "George I as Prince of HanoverWhen George I (1660-1727) arrived in England, he couldn't speak a word of English. The king's inability to communicate well with his government and subjects led him to appoint a de facto Prime Minister in the person of Robert Walpole (1676-1745). This marked a turning point in British politics, as future monarchs were also to remain more passive figures, lending the reins of the government to the Prime Minister.\n" +
                            "\n" +
                            "George II (1683-1760) was also German born. He was a powerful ruler, and the last British monarch to personally lead his troops into battle. The British Empire expanded considerably during his reign; a reign that saw notable changes, including the replacement of the Julian Calendar by the Gregorian Calendar in 1752, and moving the date of the New Year from March 25 to January 1.\n" +
                            "\n" +
                            "George III was the first Hanoverian king to be born in England.  He had one of the most troubled and interesting reigns in British history. He ascended to the throne during the Seven Years' War (1756-1763) opposing almost all the major Western powers in two teams, chiefly British against French, and ended in a de facto victory for the UK, which acquired New France (Quebec), Florida, and most of French India in the process.\n" +
                            "\n" +
                            "Thirteen years later, the American War of Independence (1776-1782) broke out and in 1782 13 American colonies were finally granted their independence, forming the United States of America.  Seven years later, the French Revolution broke out, and Louis XVI was guillotined. George III suffered from a hereditary disease known as porphyria, and his mental health seriously deteriorated from 1788. In 1800, the Act of Union merged the Kingdoms of Great Britain and Ireland.\n" +
                            "\n" +
                            "The United Kingdom during this time also had to face the ambitions of Napoleon, who desired to conquer the whole of Europe.  Admiral Nelson's naval victory at Traflagar in 1805, along with Wellington's decisive victory at Waterloo, saved the UK and further reinforced its international position. The 19th century would be dominated by the British Empire, spreading on all five continents, from Canada and the Caribbean to Australia and New Zealand, via Africa, India and South-East Asia.\n" +
                            "\n" +
                            "History of the United Kingdom:  19 Century\n" +
                            "\n" +
                            "In 1837, then king William IV died of liver disease and the throne passed to the next in line, his 18-year old niece Victoria (1819-1901), although she did not inherit the Kingdom of Hanover, where the Salic Law forbid women to rule.\n" +
                            "\n" +
                            "Victoria didn't expect to become queen, and being unmarried and inexperienced in politics she had to rely on her Prime Minister, Lord Melbourne (1779-1848).  She finally got married to her first cousin, Prince Albert of Saxe-Coburg-Gotha (1819-1861), and both were respectively niece and nephew of the first King of the Belgians, Leopold I (of Saxe-Coburg-Gotha).\n" +
                            "\n" +
                            "Britain asserted its domination on virtually every part of the globe during the 19 century, resulting in a number of wars, including the Opium Wars (1839-42 & 1856-60) with Qing China and the Boer Wars (1880-81 & 1899-1902) with the Dutch-speaking settlers of South Africa.  In 1854, the United Kingdom was brought into the Crimean War (1854-56) on the side of the Ottoman Empire and against Russia. One of the best known figures of that war was Florence Nightingale (1820-1910), who fought for the improvement of women's conditions and pioneered modern nursing.\n" +
                            "\n" +
                            "The latter years of Victoria’s reign were dominated by two influential Prime Ministers, Benjamin Disraeli (1808-1881) and his rival William Ewart Gladstone (1809-1898). The former was the favorite of the Queen, while Gladstone, a liberal, was often at odds with both Victoria and Disraeli. However, the strong party support for Gladstone kept him in power for a total of 14 years between 1868 and 1894. He is credited with legalizing trade unions, and advocating for both universal education and suffrage.\n" +
                            "\n" +
                            "Queen Victoria was to have the longest reign of any British monarch (64 years), but also the most glorious, as she ruled over 40% of the globe and a quarter of the world's population.\n" +
                            "\n" +
                            "History of the United Kingdom:  20 Century (Two World Wars)\n" +
                            "\n" +
                            "Victoria's numerous children married into many different European Royal families, The alliances between these related monarchs escalated into the Great War –WWI—from 1914-1918.  It began when Archduke Franz Ferdinand of Austria was assassinated in Sarajevo, and Austria declared war on Serbia, which in turn was allied to France, Russia and the UK. The First World War left over 9 million dead (including nearly 1 million Britons) throughout Europe, and financially ruined most of the countries involved. The monarchies in Germany, Austria, Russia and the Ottoman Empire all fell, and the map of central and Eastern Europe was completely redesigned.\n" +
                            "\n" +
                            "After World War I, the Labor Party was created in Britain. The General Strike of 1926 and the worsening economy led to radical political changes, including one in which women were finally granted the same universal suffrage as men in 1928.\n" +
                            "\n" +
                            "In 1936, Edward VIII (1894-1972) succeeded to the throne, but abdicated the same year to marry Wallis Simpson, a twice divorced American woman. His brother then unexpectedly became George VI (1895-1952) after the scandal.\n" +
                            "\n" +
                            "Nazi Germany was becoming more menacing as Hitler grew more powerful and aggressive. Finally, Britain and France were forced to declare war on Germany after the invasion of Poland in September 1939, marking the beginning of World War II.  The popular and charismatic Winston Churchill (1874-1965) became the war-time Prime Minister in 1940 and his speeches encouraged the British to fight off the attempted German invasion. In one of his most patriotic speeches before the Battle of Britain (1940), Churchill address the British people with \"We shall defend our island, whatever the cost may be, we shall fight on the beaches, we shall fight on the landing grounds, we shall fight in the fields and in the streets, we shall fight in the hills; we shall never surrender.\" And indeed, Britain did not surrender.\n" +
                            "\n" +
                            "Following World War II, the United Kingdom was bankrupt and in ruins.  The British Empire was dismantled little by little, first granting independence to India and Pakistan in 1947, then to the other Asian, African and Caribbean colonies in the 1950's and 60's. Most of these ex-colonies formed the British Commonwealth, now known as the Commonwealth of Nations. 53 states are now members of the Commonwealth, accounting for 1.8 billion people (about 30% of the global population) and about 25% of the world's land area.\n" +
                            "\n" +
                            "In 1952, the current queen of England, Elizabeth II, ascended to the throne at the age of 26. The 1960s saw the dawn of pop and rock music, with bands like the Beatles, Pink Floyd, and the Rolling Stones rising to prominence, and the Hippie subculture developing.\n" +
                            "\n" +
                            "The 1970's brought the oil crisis and the collapse of British industry. Conservative Prime minister Margaret Thatcher (b. 1925) was elected in 1979 and served until 1990.  Among other accomplishments, she privatized the railways and shut down inefficient factories, but she also increased the gap between the rich and the poor by scaling back social security. Her methods were so harsh that she was nicknamed the “Iron Lady.”\n" +
                            "\n" +
                            "Thatcher was succeeded in her party by the unpopular John Major, but in 1997, the \"New Labor\" party came back to power with the appointment of Tony Blair (b. 1953). Blair's liberal policies and unwavering support for neo-conservative US President George W. Bush (especially regarding the invasion of Iraq in 2003) disappointed many Leftists, who really saw in Blair but a Rightist in disguise. Regardless, Blair has impressed many dissenters with his intelligence and remarkable skills as an orator and negotiator.\n" +
                            "\n" +
                            "Today, the English economy relies heavily on services and, like the rest of the world, is in the process of beginning to rebuild after the global economic recession of 2008.  The main industries in the country are travel, education, prestigious automobiles and tourism.\n" +
                            "\n",
                    imagesString5  ,
                    "",
                    videosString5
                )


                dbDao.addCountry(country1)
                dbDao.addCountry(country2)
                dbDao.addCountry(country3)
                dbDao.addCountry(country4)
                dbDao.addCountry(country5)

                val countries = dbDao.getCountries()

                Log.e("Countries Main", countries.toString())


            }

            editor.putBoolean("filled", true).apply()

//        }


        discover_btn.setOnClickListener {
            val intent = Intent(this,CountriesActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {

        val dbDao = AppDatabase.invoke(this).getCountryDao()

        doAsync {

            val countries = dbDao.getInitialCountries()

            uiThread {

                if(countries!=null) refresh(countries)
            }

        }

        super.onResume()

    }

    private fun refresh(countries : MutableList<Country>){
        rv_countries.adapter = ListAdapter(this,this , countries)
    }

    override fun onItemClick(country: Country, p1: Int) {

        val intent = Intent(this, CountryDetailActivity::class.java)

        intent.putExtra("country_id",country.ID)
        intent.putExtra("name",country.name)
        intent.putExtra("drapeau",country.drapeau)
        intent.putExtra("description",country.description)
        intent.putExtra("historique",country.historique)
        intent.putExtra("capital",country.capital)
        intent.putExtra("hymne",country.hymne)
        intent.putExtra("personnalites",country.personnalites)
        intent.putExtra("population",country.population)
        intent.putExtra("ressources",country.ressources)
        intent.putExtra("surface",country.surface)
        intent.putExtra("images" ,country.images)

        startActivity(intent)

    }




}
