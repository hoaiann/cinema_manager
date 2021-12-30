package vnu.uet.cinema_manager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.*;
import vnu.uet.cinema_manager.model.Size;
import vnu.uet.cinema_manager.model.TimeCalendar;
import vnu.uet.cinema_manager.repository.*;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class InitDBService {

    private AdminRepository adminRepository;


    private PasswordEncoder passwordEncoder;

    private TicketService ticketService;

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private String convertPasswordEncoder(String password) {
        return passwordEncoder.encode(password);
    }

    @Autowired
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    private BillRepository billRepository;

    @Autowired
    public void setBillRepository(BillRepository billRepository) {
        this.billRepository = billRepository;
    }


    private CartRepository cartRepository;

    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private FilmCalendarRepository filmCalendarRepository;

    @Autowired
    public void setFilmCalendarRepository(FilmCalendarRepository filmCalendarRepository) {
        this.filmCalendarRepository = filmCalendarRepository;
    }

    private FilmRepository filmRepository;

    @Autowired
    public void setFilmRepository(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    private FoodDetailRepository foodDetailRepository;

    @Autowired
    public void setFoodDetailRepository(FoodDetailRepository foodDetailRepository) {
        this.foodDetailRepository = foodDetailRepository;
    }

    private FoodRepository foodRepository;

    @Autowired
    public void setFoodRepository(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    private RoomRepository roomRepository;

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    private TicketRepository ticketRepository;

    @Autowired
    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private FilmCalendarService filmCalendarService;

    @Autowired
    public void setFilmCalendarService(FilmCalendarService filmCalendarService) {
        this.filmCalendarService = filmCalendarService;
    }

    @PostConstruct // gọi khi các bean được khởi tạo hết
    public void init() {
        if (adminRepository.count() == 0) { // nếu db chưa có dữ liệu

            User userAdmin1 = new User("hoaian", "ROLE_ADMIN");
            userAdmin1.setPassword(convertPasswordEncoder(userAdmin1.getPassword()));
            Admin admin1 = new Admin("Dương Hoài An", "hoaian@vnu.edu.vn", userAdmin1);

            userRepository.save(userAdmin1);
            adminRepository.save(admin1);


            User userAdmin2 = new User("phucnt", "ROLE_EMPLOYEE");
            userAdmin2.setPassword(convertPasswordEncoder(userAdmin2.getPassword()));
            Admin admin2 = new Admin("Nguyễn Thị Phúc", "phucnguyen@gmail.com", userAdmin2);

            userRepository.save(userAdmin2);
            adminRepository.save(admin2);


            User userAdmin3 = new User("huyenhn", "ROLE_EMPLOYEE");
            userAdmin3.setPassword(convertPasswordEncoder(userAdmin3.getPassword()));
            Admin admin3 = new Admin("Hoàng Ngọc Huyền", "ngochuyen@gamil.com", userAdmin3);

            userRepository.save(userAdmin3);
            adminRepository.save(admin3);


            User userAdmin4 = new User("linhnn", "ROLE_EMPLOYEE");
            userAdmin4.setPassword(convertPasswordEncoder(userAdmin4.getPassword()));
            Admin admin4 = new Admin("Nguyễn Ngọc Linh", "linhnguyen@gmail.com", userAdmin4);

            userRepository.save(userAdmin4);
            adminRepository.save(admin4);


            User userAdmin5 = new User("minhnh", "ROLE_EMPLOYEE");
            userAdmin5.setPassword(convertPasswordEncoder(userAdmin5.getPassword()));
            Admin admin5 = new Admin("Nguyễn Hoàng Minh", "minhnguyen@gamil.com", userAdmin5);

            userRepository.save(userAdmin5);
            adminRepository.save(admin5);

            User userAdmin6 = new User("ngocly", "ROLE_EMPLOYEE");
            userAdmin6.setPassword(convertPasswordEncoder(userAdmin6.getPassword()));
            Admin admin6 = new Admin("Nguyễn Ngọc Ly", "ngocly@gmail.com", userAdmin6);

            userRepository.save(userAdmin6);
            adminRepository.save(admin6);

            User userAdmin7 = new User("admin", "ROLE_ADMIN");
            userAdmin7.setPassword(convertPasswordEncoder(userAdmin7.getPassword()));
            Admin admin7 = new Admin("Admin", "admin@gmail.com", userAdmin7);

            userRepository.save(userAdmin7);
            adminRepository.save(admin7);

            User user1 = new User("anhnguyen");
            Cart cart1 = new Cart();
            user1.setPassword(convertPasswordEncoder(user1.getPassword()));
            Customer customer1 = new Customer("145678901", "Nguyễn Ngọc Anh", "098787986", "anhnguyen@gmail.com", "Hà Đông, Hà Nội", false, LocalDate.of(2021, 12, 12), cart1, user1);
            cartRepository.save(cart1);
            userRepository.save(user1);
            customerRepository.save(customer1);

            User user2 = new User("lannguyen");
            Cart cart2 = new Cart();
            user2.setPassword(convertPasswordEncoder(user2.getPassword()));
            Customer customer2 = new Customer("134568765", "Nguyễn Ngọc Lan", "0956457642", "lannguyen@gmail.con", "Thanh Xuân, Hà Nội", false, LocalDate.of(2021, 12, 10), cart2, user2);
            cartRepository.save(cart2);
            userRepository.save(user2);
            customerRepository.save(customer2);

            User user3 = new User("minhnguyen");
            Cart cart3 = new Cart();
            user3.setPassword(convertPasswordEncoder(user3.getPassword()));
            Customer customer3 = new Customer("167687569", "Nguyễn Đức Minh", "0945678764", "minhnguyen@gmail.com", "Ba Đình, Hà Nội", true, LocalDate.of(2021, 12, 15), cart3, user3);
            cartRepository.save(cart3);
            userRepository.save(user3);
            customerRepository.save(customer3);

            User user4 = new User("longnguyen");
            Cart cart4 = new Cart();
            user4.setPassword(convertPasswordEncoder(user4.getPassword()));
            Customer customer4 = new Customer("145676543", "Nguyễn Văn Long", "0967876543", "longnguyen@gmail.com", "Cầu Giấy, Hà Nội", true, LocalDate.of(2021, 12, 20), cart4, user4);
            cartRepository.save(cart4);
            userRepository.save(user4);
            customerRepository.save(customer4);

            User user5 = new User("maihoang");
            Cart cart5 = new Cart();
            user5.setPassword(convertPasswordEncoder(user5.getPassword()));
            Customer customer5 = new Customer("156576534", "Hoàng Thị Mai", "0376567456", "maihoang@gmail.com", "Hoàng Mai, Hà Nội", false, LocalDate.of(2021, 12, 13), cart5, user5);
            cartRepository.save(cart5);
            userRepository.save(user5);
            customerRepository.save(customer5);

            User user6 = new User("ngochoang");
            Cart cart6 = new Cart();
            user6.setPassword(convertPasswordEncoder(user6.getPassword()));
            Customer customer6 = new Customer("176456334", "Hoàng Lan Ngọc", "0376565476", "ngochoang@gmail.com", "Hoàng Mai, Hà Nội", false, LocalDate.of(2021, 12, 14), cart6, user6);
            cartRepository.save(cart6);
            userRepository.save(user6);
            customerRepository.save(customer6);

            User user7 = new User("hungtran");
            Cart cart7 = new Cart();
            user7.setPassword(convertPasswordEncoder(user7.getPassword()));
            Customer customer7 = new Customer("156512344", "Trần Văn Hùng", "0376574563", "hungg@gmail.com", "Hai Bà Trưng, Hà Nội", false, LocalDate.of(2021, 12, 16), cart7, user7);
            cartRepository.save(cart7);
            userRepository.save(user7);
            customerRepository.save(customer7);


            System.out.println("Success init account admin, customer");

            Room room1 = new Room("101", 40);
            roomRepository.save(room1);
            Room room2 = new Room("102", 45);
            roomRepository.save(room2);
            Room room3 = new Room("103", 50);
            roomRepository.save(room3);
            Room room4 = new Room("201", 55);
            roomRepository.save(room4);
            Room room5 = new Room("202", 30);
            roomRepository.save(room5);
            Room room6 = new Room("203", 15);
            roomRepository.save(room6);
            Room room7 = new Room("204", 20);
            roomRepository.save(room7);


            System.out.println("Success init room ");


            Film film1 = new Film("Nguời nhện không còn nhà", "Jon Watts", "Tom Holland, Zendaya, Benedict Cumberbatch, Jacob Batalon, Jon Favreau", "Hành động, phiêu lưu", LocalDate.of(2021, 12, 17), "149", BigDecimal.valueOf(119000), "Lần đầu tiên trong lịch sử điện ảnh của Người Nhện, thân phận người hàng xóm thân thiện bị lật mở, khiến trách nhiệm làm một Siêu Anh Hùng xung đột với cuộc sống bình thường và đặt người anh quan tâm nhất vào tình thế nguy hiểm. Khi anh nhờ đến giúp đỡ của Doctor Strange để khôi phục lại bí mật, phép thuật đã gây ra lỗ hổng thời không, giải phóng những ác nhân mạnh mẽ nhất từng đối đầu với Người Nhện từ mọi vũ trụ. Bây giờ, Peter sẽ phải vượt qua thử thách lớn nhất của mình, nó sẽ thay đổi không chỉ tương lai của chính anh mà còn là tương lai của cả Đa Vũ Trụ.", "");
            filmRepository.save(film1);
            Film film2 = new Film("Ma trận: Hồi sinh", "Lana Wachowski", "Keanu Reeves, Carrie-Anne Moss, Yahya Abdul-Mateen II, Jessica Henwick, Jonathan Groff, Neil Patrick Harris, Priyanka Chopra Jonas và Christina Ricci", "Hành Động, Khoa Học Viễn Tưởng", LocalDate.of(2021, 12, 24), " 148 ", BigDecimal.valueOf(109000), "Ma Trận: Hồi Sinh là phần phim tiếp theo rất được trông đợi của loạt phim “Ma Trận” đình đám, đã góp phần tái định nghĩa thể loại phim khoa học viễn tưởng. Phần phim mới nhất này đón chào sự trở lại của cặp đôi Keanu Reeves và Carrie-Anne Moss với vai diễn biểu tượng đã làm nên tên tuổi của họ, Neo và Trinity. Ngoài ra, phim còn có sự góp mặt của dàn diễn viên đầy tài năng gồm Yahya Abdul-Mateen II, Jessica Henwick, Jonathan Groff, Neil Patrick Harris, Priyanka Chopra Jonas và Christina Ricci.", "");
            filmRepository.save(film2);
            Film film3 = new Film("Nhóc trùm: Nối nghiệp gia đình", "Tom McGrath", "Amy Sedaris, Jeff Goldblum, James Marsden", "Hoạt Hình", LocalDate.of(2021, 12, 24), "105", BigDecimal.valueOf(99000), "Nhóc trùm Ted giờ đây đã trở thành một triệu phú nổi tiếng trong khi Tim lại có một cuộc sống đơn giản bên vợ anh Carol và hai cô con gái nhỏ yêu dấu. Mỗi mùa Giáng sinh tới, cả Tina và Tabitha đều mong được gặp chú Ted nhưng dường như hai anh em nhà Templeton nay đã không còn gần gũi như xưa. Nhưng bất ngờ thay khi Ted lại có màn tái xuất không thể hoành tráng hơn khi đáp thẳng máy bay trực thăng tới nhà Tim trước sự ngỡ ngàng của cả gia đình.", "");
            filmRepository.save(film3);
            Film film4 = new Film("Hố sụt tử thần", "Kim Ji Hoon", "Cha Seung Won, Kim Sung Kyun, Lee Kwang Soo, Kim Hye Jun…", "Hài, Hồi hộp", LocalDate.of(2021, 12, 24), "117", BigDecimal.valueOf(89000), "Trong lúc Park Dong Won tổ chức tiệc tân gia, một chiếc hố sụt khổng lồ đã bất ngờ nuốt chửng anh cùng căn hộ mới mua xuống độ sâu 500 mét. Tuy may mắn sống sót, nhưng Park Dong Won cần phải nhanh chóng hợp lực với các vị khách và những cư dân khác để thoát khỏi tòa chung cư đổ nát, trước khi chiếc hố bị nước mưa nhấn chìm.", "");
            filmRepository.save(film4);
            Film film5 = new Film("Câu chuyện phía Tây", "Steven Spielberg", "Ansel Elgort, Rachel Zegler, Ariana DeBose, David Alvarez, Mike Faist, Josh Andrés Rivera, Ana Isabelle, Corey Stoll, Brian d’Arcy James, Rita Moreno", "Nhạc kịch, Tình cảm", LocalDate.of(2021, 12, 24), "156", BigDecimal.valueOf(79000), "Được đạo diễn bởi đạo diễn gạo cội từng giành giải Oscar Steven Spielberg, cùng kịch bản bởi biên kịch từng giành giải Pulitzer Prize và giải Tony Award, Tony Kushner, Câu chuyện phía Tây kể lại câu chuyện tình yêu kinh điển của Tony và Maria, giữa sự giằng xé của tình yêu trẻ tuổi và sự ngăn cấm, thù hằn ở thành phố NewYork những năm 1950.", "");
            filmRepository.save(film5);
            Film film6 = new Film("Blackpink the movie", "Su Yee Jung, Oh Yoon-Dong", "JISOO, JENNIE, ROSÉ, LISA", "Phim tài liệu", LocalDate.of(2021, 12, 24), "99", BigDecimal.valueOf(119000), "Nhóm nhạc nữ được yêu thích toàn cầu, BLACKPINK sẽ kỷ niệm năm thứ 5 hoạt động của nhóm với việc phát hành BLACKPINK THE MOVIE, đây cũng như là món quà đặc biệt dành tặng cho các BLINK— fandom của BLACKPINK — bộ phim sẽ tái hiện một cách sống động những kỷ niệm không thể quên cùng những màn trinh diễn đầy cuồng nhiệt đúng tinh thần lễ hội.", "");
            filmRepository.save(film6);
            Film film7 = new Film("Dooraemon: Luôn bên bạn 2", "Ryuichi Yagi, Takashi Yamazaki", "Wasabi Mizuta, Megumi Oohara, Yumi Kakazu, Subaru Kimura, Tomokazu Seki", "Hài, Hoạt Hình", LocalDate.of(2021, 12, 17), "96", BigDecimal.valueOf(109000), "Một ngày nọ, Nobita vô tình tìm thấy chú gấu bông cũ, món đồ chơi chất chứa bao kỉ niệm cùng người bà đáng kính. Với khát khao “muốn gặp bà lần nữa”, Nobita đã trở về quá khứ bằng cổ máy thời gian, bất chấp sự phản đối của Doraemon. Dù ngạc nhiên, bà vẫn tin cậu thiếu niên lớn tướng trước mặt mình là cháu mình. Trước nguyện vọng tha thiết “mong được thấy cháu dâu một lần”, chuyến phiêu lưu của Doraemon và Nobita bắt đầu. Nobita muốn cho bà xem đám cưới của mình, nhưng đúng ngày thành hôn với Shizuka, chú rể Nobita lại trốn mất? Jaian và Suneo chạy đôn chạy đáo tìm bạn, còn Shizuka vẫn tin tưởng chờ đợi Nobita. Để thực hiện nguyện vọng của bà, đáp lại niềm tin của gia đình, bạn bà và Shizuka yêu quý, Nobita sẽ cùng Doraemon du hành vượt thời gian. Họ sẽ mang đến cho chúng ta một câu chuyện cảm động đến rơi lệ về quan hệ con người, kết nối giữa quá khứ, hiện tại và tương lai.", "");
            filmRepository.save(film7);
            Film film8 = new Film("VENOM: Đối mặt tử thù", "Andy Serkis", "Tom Hardy, Michelle Williams, Woody Harrelson, Naomie Harris", "Hành Động, Khoa Học Viễn Tưởng, Phiêu Lưu, Thần thoại", LocalDate.of(2021, 12, 10), "97", BigDecimal.valueOf(99000), "Siêu bom tấn #VENOM: LET THERE BE CARNAGE hứa hẹn trận chiến khốc liệt nhất giữa Venom và kẻ thù truyền kiếp, Carnage.", "");
            filmRepository.save(film8);
            Film film9 = new Film("DUNE: Hành tinh cát", "Denis Villeneuve", "Timothée Chalamet, Rebecca Ferguson, Zendaya", "Hành Động, Phiêu Lưu, Tâm Lý", LocalDate.of(2021, 12, 10), "156", BigDecimal.valueOf(89000), "Là chuyến hành trình sử thi đầy cảm xúc của Paul Atreides – một chàng thanh niên trẻ tài ba xuất chúng được sinh ra với một sứ mệnh vĩ đại vượt ngoài tầm hiểu biết của chính bản thân anh. Paul đã phải du hành tới hành tinh nguy hiểm nhất trong Vũ trụ để đảm bảo được tương lai cho gia đình cũng như những người dân của anh ấy. Khi các thế lực tàn độc bắt đầu lao vào cuộc xung đột nhằm tranh giành độc quyền nguồn tài nguyên có giá trị nhất hành tinh – thứ nhiên liệu quý giá có khả năng kích hoạt những tiềm năng lớn nhất của nhân loại – chỉ những người chiến thắng được nỗi sợ hãi của mình mới có thể sống sót", "");
            filmRepository.save(film9);
            Film film10 = new Film("Chủng tộc bất tử", "Chloé Zhao", "Gemma Chan, Angelina Jolie, Salma Hayek, Richard Madden, Kit Harington, Barry Keoghan", "Hành Động, Phiêu Lưu, Thần thoại", LocalDate.of(2021, 12, 03), "155", BigDecimal.valueOf(79000), "Chủng Tộc Bất Tử là một chủng tộc ngoài hành tinhh đã ẩn mình trong loài người hàng nghìn năm. Từ lâu, họ đã dõi theo và giúp loài người tiến bộ, chứng kiến các đế chế trỗi dậy và lụi tàn, các thành tựu vĩ đại của con người với quy tắc không can thiệp. Nhưng sau sự kiện Avengers: Endgame (2019), mọi thứ đã thay đổi. Các thành viên giờ phải bước ra khỏi bóng tối, đoàn kết chống lại The Deviants - một kẻ thù lâu đời đe dọa Trái Đất.", "");
            filmRepository.save(film10);
            Film film11 = new Film("Ám thuật: Xác sống săn mồi", "KIM Yong Wan", "UHM Ji Won, JEONG Ji So, JEONG Moon Sung, KIM In Kwon, KO Kyu Pil", "Hành Động, Kinh Dị, Tâm Lý, Thần thoại", LocalDate.of(2021, 12, 17), "109", BigDecimal.valueOf(119000), "Tại hiện trường vụ án mạng, cảnh sát vô cùng bối rối khi phát hiện nghi phạm là một cái xác đã chết từ 3 tháng trước. Trong lúc đó, phóng viên Im Jin Hee nhận được một cuộc gọi từ kẻ tự xưng là hung thủ của vụ án bí ẩn. Hắn muốn thực hiện một buổi phỏng vấn. Trong buổi phát sóng trực tiếp, hắn ta nói rằng sẽ tiếp tục thực hiện 3 vụ giết người bằng xác chết tái sinh. Vào ngày xảy ra vụ giết người được báo trước đầu tiên, một đội quân xác sống xuất hiện và bất ngờ tấn công cảnh sát. Ai là kẻ chủ mưu, và lý do sau tất cả là gì? ", "");
            filmRepository.save(film11);
            Film film12 = new Film("CLIFFORD Chú chó đỏ khổng lồ", "Walt Becker", "Darby Camp, Jack Whitehall, Izaac Wang, John Cleese,…", "Gia đình, Hài, Hoạt Hình", LocalDate.of(2021, 12, 31), "", BigDecimal.valueOf(109000), "Một cô bé nhỏ đã dành thật nhiều tình yêu cho chú cún màu đỏ đặc biệt của mình và sau một đêm chú cún đã hóa khổng lồ. Cuộc hành trình vui nhộn cùng chú chó đỏ khổng lồ bắt đầu từ đây.", "");
            filmRepository.save(film12);
            Film film13 = new Film("Không phải lúc chết", "Cary Joji Fukunaga", "Daniel Craig, Rami Malek, Léa Seydoux", "Hành Động", LocalDate.of(2021, 12, 31), "", BigDecimal.valueOf(99000), "Phần 25 của bộ phim điệp viên huyền thoại 007 sẽ tiếp nối câu chuyện về James Bond cùng những pha hành động táo bạo và hoành tráng hơn bao giờ hết. Sau sự kiện đầy ám ảnh trong Spectre, Bond lui về ở ẩn tại đất nước Jamaica, sống một cuộc đời cô độc nhưng bình lặng. Bỗng một người bạn cũ từ CIA xuất hiện, cầu xin anh giúp đỡ. Bond bất đắc dĩ phải tái xuất, nhưng không hề biết mình sẽ đối đầu với thế lực nào. Chi tiết đáng chú ý nhất là chiếc mặt nạ trắng vỡ nửa, đánh dấu sự xuất hiện của tên ác nhân kì quái bậc nhất trong cả series 007. Màn chạm trán giữa Bond và kẻ thù nguy hiểm này sẽ vén màn những bí ẩn còn để ngỏ và tiếp theo đó, có thể là một cuộc đối đầu “sinh tử”.", "");
            filmRepository.save(film13);
            Film film14 = new Film("Rừng thế mạng", "Trần Hữu Tấn", "Huỳnh Thanh Trực, Trần Phong, Thùy Anh, Thùy Dương, Lê Quang Vinh, Nguyễn Phước Lộc, NSƯT. Hữu Châu, Kiều Trinh, Bích Hằng, Hưng Võ", " Hồi hộp", LocalDate.of(2021, 12, 31), "94", BigDecimal.valueOf(89000), "Tà Năng - Phan Dũng, cung đường trekking đẹp nhất Việt Nam với những câu chuyện tâm linh kỳ bí chưa có lời giải đáp. Dù được cảnh báo sự nguy hiểm và mỗi năm sẽ có người thế mạng, nhưng một phượt thủ trẻ vẫn quyết định tách đoàn để tìm người bạn thân đi lạc. Hơn 10 ngày đêm kiệt quệ, anh không chỉ rơi vào cuộc chiến sinh tồn chốn rừng thiêng nước độc, mà còn đối mặt với những ám ảnh rùng rợn như ai đó từng nói ma đưa lối, quỷ dẫn đường…", "");
            filmRepository.save(film14);
            Film film15 = new Film("Happy new year", "Kwak Jae Young", "Han Ji Min, Lee Dong Wook, Kang Ha Neul, Lim Yoona, Won Jin Ah, Lee Hye Young, Jung Jin Young, Kim Young Kwang, Seo Kang Joon, Lee Kwang Soo, Ko Sung Hee, Lee Jin Wook, Cho Jun Young, Won Ji An", "Tình cảm", LocalDate.of(2021, 12, 31), "", BigDecimal.valueOf(79000), "HAPPY NEW YEAR là bức tranh gồm những mảnh ghép đầy thú vị về những vị khách tới với khách sạn Emross dịp cuối năm. Mỗi người một câu chuyện riêng, cảm xúc riêng, góc nhìn riêng và mong cầu riêng đối với tình yêu và cuộc sống. Đây là nơi mà người ta ở lại, rời đi, gặp gỡ, rồi chia tay. Liệu chúng ta cũng sẽ tìm thấy ai đó đặc biệt cho riêng mình chứ? – câu hỏi không chỉ dành cho các nhân vật, mà còn là nỗi niềm của mỗi người trong chúng ta sau một năm khó khăn vừa qua. Lời giải đáp sẽ đến cùng Happy New Year vào ngày 31.12.2021", "");
            filmRepository.save(film15);
            Film film16 = new Film("Kingsman:Khởi nguồn ", "Matthew Vaughn", "Gemma Arterton, Ralph Fiennes, Colin Firth, Stanley", "Hài, Hành Động, Phiêu Lưu", LocalDate.of(2022, 01, 01), "", BigDecimal.valueOf(119000), "Tiếp tục là những nhiệm vụ tưởng chừng như bất khả thi nhằm giải cứu nhân loại của tổ chức mật vụ nổi tiếng bậc nhất màn ảnh rộng. Đặc biệt lần này, đối thủ của họ gồm một nhóm người được coi là những kẻ khủng bố và tàn bạo hàng đầu. Cùng chờ xem liệu cuộc chiến lần này sẽ diễn ra như thế nào?", "");
            filmRepository.save(film16);
            Film film17 = new Film("Bóng đè", "Lê Văn Kiệt", " Lâm Thanh Mỹ, Quang Tuấn, Mai Cát Vi, Diệu Nhi", " Kinh Dị", LocalDate.of(2022, 01, 10), "", BigDecimal.valueOf(109000), "Bóng đè là trải nghiệm xảy ra khi tâm trí đã thức giấc nhưng cơ thể vẫn còn trong giấc ngủ. Đa số trường hợp không thể phân biệt được giữa thực và mơ. Theo thống kê, 40% dân số thế giới từng bị bóng đè ít nhất một lần trong đời. BÓNG ĐÈ- phim điện ảnh Việt đầu tiên khai thác về hiện tượng bóng đè, cầm trịch bởi Lê Văn Kiệt – đạo diễn Hai Phượng. Chuyển đến một căn nhà cổ ở vùng quê, ba cha con Thành (Quang Tuấn), Linh (Lâm Thanh Mỹ) và Yến (Mai Cát Vi) hy vọng về một cuộc sống mới. Nhưng chào đón họ là hàng loạt những hiện tượng kỳ dị ập đến mỗi khi chìm vào giấc ngủ ... Giờ lành đã điểm, quỷ dữ thức giấc ...", "");
            filmRepository.save(film17);
            Film film18 = new Film("Hố địa ngục", "Arseny Syuhin", " Milena Radulovic, Sergey Ivanyuk, Nikolay Kovbas", "Hồi hộp, Kinh Dị", LocalDate.of(2022, 01, 15), "", BigDecimal.valueOf(99000), "Hố khoan Kola Superdeep của Nga được khoan sâu 12.000m vào lòng đất – là cơ sở nghiên cứu bí mật sâu nhất thế giới được ghi lại cho đến nay. Vào năm 1984, các nhà khoa học bắt đầu nghe được những âm thanh lạ vọng từ hố sâu Kola và quyết định đóng cửa cơ sở nghiên cứu này. Một nhóm nghiên cứu đã quyết định thám hiểm hố khoan để tìm ra bí mật mà nơi đây đang ẩn giấu. Tuy nhiên, từng thành viên trong nhóm nghiên cứu đều lần lượt bỏ mạng. Những gì họ tìm thấy kinh khủng hơn bất cứ điều từng được ghi chép lại về chiếc hố tử thần này.", "");
            filmRepository.save(film18);
            Film film19 = new Film("Chuyện ma gần nhà", "Trần Hữu Tấn", "Khả Như, Vân Trang, Mạc Can, Huỳnh Thanh Trực,…", "Kinh Dị", LocalDate.of(2022, 02, 11), "", BigDecimal.valueOf(89000), "Là tác phẩm đầu tiên trong vũ trụ kinh dị Việt Nam được lấy cảm hứng từ những truyền thuyết đô thị và các câu chuyện ma được đồn thổi trong dân gian. Bộ phim mang màu sắc u ám, quỷ dị với chất liệu từ cuộc sống đời thường. Văn hoá và tín ngưỡng, phong tục tập quán của người Việt Nam sẽ là một điểm nhấn trong tác phẩm này, bên cạnh những cảnh kinh dị.", "");
            filmRepository.save(film19);
            Film film20 = new Film("Đấu trường âm nhạc 2", "Garth Jennings", "Matthew Scarlett Johansson, Taron Egerton, Tori Kelly, Halsey, Pharrell Williams,...", "Hoạt Hình", LocalDate.of(2022, 02, 01), "", BigDecimal.valueOf(79000), "Sau khi thành công rực rỡ tại quê nhà, Buster Moon và các bạn quyết định dấn thân vào một cuộc chinh phục âm nhạc mới hoành tráng và cam go hơn bao giờ hết.", "");
            filmRepository.save(film20);
            Film film21 = new Film("FAST & FURIOUS 9", "Justin Lin", "Charlize Theron, Jim Parrack, John Cena", "Hành Động, Phiêu Lưu", LocalDate.of(2022, 01, 07), "", BigDecimal.valueOf(119000), "Plot unknown. The ninth installment of the Fast and Furious  franchise.", "");
            filmRepository.save(film21);
            Film film22 = new Film("Sự Nổi Loạn Hoàn Hảo 3", "Trish Sie", "Ruby Rose, Hailee Steinfeld, Anna Kendrick", " Hài, Nhạc kịch", LocalDate.of(2017, 12, 29), "94", BigDecimal.valueOf(109000), "Sau chiến thắng tại giải Vô địch Thế giới, nhóm Bellas đã tan rã và phát hiện ra rằng họ chẳng thể tìm được công việc nào bằng giọng ca của mình. Nhưng ngay khi có cơ hội tham gia tour diễn nước ngoài của tổ chức USO, nhóm nhạc của những cô nàng mọt sách cá tính sẽ lại tái hợp để lần cuối cùng nhau cất cao giọng hát và đưa ra quyết định cho những điều họ còn băn khoăn.", "");
            filmRepository.save(film22);
            Film film23 = new Film("Người Kiến Và Chiến Binh Ong", "Peyton Reed", "Evangeline Lilly, Michelle Pfeiffer, Walton Goggins", "Hành Động, Phiêu Lưu", LocalDate.of(2018, 07, 06), "122", BigDecimal.valueOf(99000), "Sau trận nội chiến khốc liệt, Scott Lang – anh hùng Người Kiến với khả năng phóng to, thu nhỏ lại phải đối mặt với sự lựa chọn khó khăn trong cuộc sống đời thường: làm siêu anh hùng gánh vác những trách nhiệm nặng nề của thế giới hay làm một người cha có trách nhiệm. Trong lúc ấy, Scott được tiến sĩ Hank Pym và Hope Van Dyne – Chiến Binh Ong triệu tập để thực hiện một nhiệm vụ cấp bách mới. Scott sẽ phải mặc vào bộ áo Người Kiến một lần nữa và chiến đấu bên cạnh chiến binh ong để lật mở những bí ẩn trong quá khứ.", "");
            filmRepository.save(film23);
            Film film24 = new Film("100 Ngày Bên Em", "Vũ Ngọc Phượng", "un Phạm, Khả Ngân, B Trần, Lê Tam Triều Dâng, Gin Tuấn Kiệt, NSƯT Mỹ Uyên, NSƯT Chiều Xuân….", "Tình cảm", LocalDate.of(2018, 04, 25), "99", BigDecimal.valueOf(89000), "Ngày Bên Em là câu chuyện về hai con người tưởng chừng như ở hai thế giới khác nhau nhưng nhờ một “biến cố” mà đã tìm thấy tình yêu của đời mình. Họ đến bên nhau, cháy hết mình cho tuổi trẻ, cho tình yêu. Để rồi, nếu chẳng may có buông tay nhau ra, cả hai không phải hối tiếc điều gì.", "");
            filmRepository.save(film24);
            Film film25 = new Film("Và Em Sẽ Đến", "Jang-Hoon Lee", "Ji-seob So, Ye-jin Son, Yoo-ram Bae", "Thần thoại, Tình cảm", LocalDate.of(2018, 04, 06), "132", BigDecimal.valueOf(79000), "Và Em Sẽ Đến bắt đầu với một lời hứa từ Soo A (Son Ye Jin) vào cơn mưa đầu mùa cô ấy sẽ quay về với với chồng mình Woo Jin (So Ji Sub) và con trai Ji Ho (Kim Ji Hwan). Nhưng khi trở lại, Soo A hoàn toàn không còn ký ức về thực tại các mối quan hệ mà cô từng có trước đây. Woo Jin đã từng bước để giúp Soo A khơi dậy từng ký ức mà cô đã lãng quên. Bằng những mảnh ghép từ tình yêu đơn phương anh dành cho cô, ngày hẹn hò đầu tiên từ thời phổ thông, và nụ hôn đầu tiên… Một lần nữa, Woo Jin và Soo A lại yêu nhau.", "");
            filmRepository.save(film25);
            Film film26 = new Film("Giải Cứu Công Chúa", " Oleh Malamuzh", "Nadiya Dorofeeva, Oleksiy Zavhorodniy, Yevhen Malukha", "Hoạt Hình, Phiêu Lưu", LocalDate.of(2018, 04, 13), "90", BigDecimal.valueOf(119000), "Cứ mỗi trăm năm, lão phù thủy độc ác Chernomor lại bắt cóc một nàng công chúa, nhưng lần này nàng công chúa Mila chẳng phải dạng vừa. Hơn nữa, nàng còn có người yêu là hiệp sĩ Ruslan dũng cảm, mèo bự biến hình, chuột hamster thông minh, chim hoàng yến gan dạ ... Nào cùng lên đường GIẢI CỨU CÔNG CHÚA", "");
            filmRepository.save(film26);
            System.out.println("Success init film");

            Food food1 = new Food("CoCa CoLa");
            foodRepository.save(food1);

            FoodDetail foodDetails1_1 = new FoodDetail(Size.S, BigDecimal.valueOf(10000), 70, true, food1);
            foodDetailRepository.save(foodDetails1_1);

            FoodDetail foodDetails1_2 = new FoodDetail(Size.M, BigDecimal.valueOf(15000), 50, false, food1);
            foodDetailRepository.save(foodDetails1_2);

            FoodDetail foodDetails1_3 = new FoodDetail(Size.L, BigDecimal.valueOf(20000), 20, true, food1);
            foodDetailRepository.save(foodDetails1_3);

            Food food2 = new Food("Pepsi");
            foodRepository.save(food2);

            FoodDetail foodDetails2_1 = new FoodDetail(Size.S, BigDecimal.valueOf(10000), 10, true, food2);
            foodDetailRepository.save(foodDetails2_1);

            FoodDetail foodDetails2_2 = new FoodDetail(Size.M, BigDecimal.valueOf(15000), 5, false, food2);
            foodDetailRepository.save(foodDetails2_2);

            FoodDetail foodDetails2_3 = new FoodDetail(Size.L, BigDecimal.valueOf(20000), 20, true, food2);
            foodDetailRepository.save(foodDetails2_3);

            Food food3 = new Food("Sprite");
            foodRepository.save(food3);

            FoodDetail foodDetails3_1 = new FoodDetail(Size.S, BigDecimal.valueOf(10000), 15, true, food3);
            foodDetailRepository.save(foodDetails3_1);

            FoodDetail foodDetails3_2 = new FoodDetail(Size.M, BigDecimal.valueOf(15000), 50, false, food3);
            foodDetailRepository.save(foodDetails3_2);

            FoodDetail foodDetails3_3 = new FoodDetail(Size.L, BigDecimal.valueOf(20000), 30, true, food3);
            foodDetailRepository.save(foodDetails3_3);

            Food food4 = new Food("Fanta");
            foodRepository.save(food4);

            FoodDetail foodDetails4_1 = new FoodDetail(Size.S, BigDecimal.valueOf(10000), 50, true, food4);
            foodDetailRepository.save(foodDetails4_1);

            FoodDetail foodDetails4_2 = new FoodDetail(Size.M, BigDecimal.valueOf(15000), 50, false, food4);
            foodDetailRepository.save(foodDetails4_2);

            FoodDetail foodDetails4_3 = new FoodDetail(Size.L, BigDecimal.valueOf(20000), 20, true, food4);
            foodDetailRepository.save(foodDetails4_3);

            Food food5 = new Food("Milo");
            foodRepository.save(food5);

            FoodDetail foodDetails5_1 = new FoodDetail(Size.S, BigDecimal.valueOf(10000), 5, true, food5);
            foodDetailRepository.save(foodDetails5_1);

            FoodDetail foodDetails5_2 = new FoodDetail(Size.M, BigDecimal.valueOf(15000), 10, false, food5);
            foodDetailRepository.save(foodDetails5_2);

            FoodDetail foodDetails5_3 = new FoodDetail(Size.L, BigDecimal.valueOf(20000), 20, true, food5);
            foodDetailRepository.save(foodDetails5_3);

            Food food6 = new Food("Bỏng ngô");
            foodRepository.save(food6);

            FoodDetail foodDetails6_1 = new FoodDetail(Size.M, BigDecimal.valueOf(50000), 20, false, food6);
            foodDetailRepository.save(foodDetails6_1);

            FoodDetail foodDetails6_2 = new FoodDetail(Size.L, BigDecimal.valueOf(70000), 20, true, food6);
            foodDetailRepository.save(foodDetails6_2);


            Food food7 = new Food("Bỏng ngô vị caramen");
            foodRepository.save(food7);

            FoodDetail foodDetails7_1 = new FoodDetail(Size.M, BigDecimal.valueOf(60000), 30, false, food7);
            foodDetailRepository.save(foodDetails7_1);

            FoodDetail foodDetails7_2 = new FoodDetail(Size.L, BigDecimal.valueOf(80000), 20, true, food7);
            foodDetailRepository.save(foodDetails7_2);

            Food food8 = new Food("Bỏng ngô vị phô mai");
            foodRepository.save(food8);

            FoodDetail foodDetails8_1 = new FoodDetail(Size.M, BigDecimal.valueOf(60000), 40, false, food8);
            foodDetailRepository.save(foodDetails8_1);

            FoodDetail foodDetails8_2 = new FoodDetail(Size.L, BigDecimal.valueOf(80000), 40, true, food8);
            foodDetailRepository.save(foodDetails8_2);

            Food food9 = new Food("Bỏng ngô mix");
            foodRepository.save(food9);

            FoodDetail foodDetails9_1 = new FoodDetail(Size.M, BigDecimal.valueOf(70000), 10, false, food9);
            foodDetailRepository.save(foodDetails9_1);

            FoodDetail foodDetails9_2 = new FoodDetail(Size.L, BigDecimal.valueOf(90000), 10, true, food9);
            foodDetailRepository.save(foodDetails9_2);
            System.out.println("Success init food");


            FilmCalendar filmCalendar1 = new FilmCalendar(LocalDate.of(2022, 1, 8), TimeCalendar.CASE_1, film1, room1);
            filmCalendarRepository.save(filmCalendar1);
            ticketService.createTicketWhenCreateFilmCalendar(filmCalendar1);

            System.out.println("Success init film calendar");


        }


    }

}
