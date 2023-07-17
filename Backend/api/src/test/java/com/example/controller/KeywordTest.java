package com.example.controller;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.controller.KeywordGenerator.generateKeywords;

public class KeywordTest {
    private static String CONTENT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquet sed enim vitae maximus. Suspendisse purus tortor, laoreet molestie metus eget, placerat tempor tellus. Ut ultrices lacus a elit fringilla commodo. Nulla pulvinar hendrerit interdum. Aenean consequat odio nunc, a efficitur ex elementum vel. Sed molestie, orci eu dictum molestie, dolor est dignissim nisi, quis consequat diam neque eget mi. Phasellus luctus condimentum ligula ac elementum. Etiam sagittis eros ac ullamcorper ultricies. Fusce in est ut sapien dignissim imperdiet non non ipsum. Aenean a dui in ante convallis finibus ut sed felis. Nam ornare gravida rhoncus.\n" +
            "\n" +
            "Vestibulum sit amet tempus urna. Nullam iaculis convallis condimentum. Donec pretium sem ac nisi accumsan ultrices non ac diam. Nulla et ante vitae arcu auctor facilisis scelerisque vestibulum lectus. Nullam a ante nulla. Vivamus imperdiet tincidunt mi. Cras blandit vestibulum odio, vel ornare elit ultricies eu. Fusce accumsan convallis eros. Aliquam varius ex a iaculis pellentesque. Mauris est arcu, imperdiet ac mi sed, semper fringilla metus. Nunc semper lacinia lobortis. Cras auctor lectus vitae metus facilisis ornare. Nunc ornare tempor hendrerit. Nullam hendrerit tortor sit amet posuere gravida. Integer leo augue, placerat ut eros vel, varius malesuada justo. Ut rutrum turpis nec leo varius, ut fermentum enim maximus.\n" +
            "\n" +
            "Nulla facilisi. Sed quis metus feugiat, lacinia mauris et, mattis augue. Sed scelerisque sit amet ligula nec vehicula. Sed nec justo vel odio accumsan tincidunt. Vivamus imperdiet et velit non volutpat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aenean a dictum libero. Ut condimentum dui id libero imperdiet rhoncus. Vestibulum tincidunt condimentum lorem quis varius. Suspendisse aliquet vel felis eu consequat. Aenean ac nibh orci. Sed pharetra dictum urna, quis tempor nunc consectetur sit amet. Suspendisse ex lacus, interdum eget tortor at, rhoncus imperdiet tellus. Aliquam sit amet finibus lorem. Fusce molestie at magna vitae euismod.\n" +
            "\n" +
            "Phasellus id purus rhoncus, auctor leo vel, suscipit nisl. Donec laoreet metus in turpis tempor, eget pretium nisl varius. Nam sed justo ultrices velit tempor viverra. Nunc semper dictum lectus non laoreet. Quisque iaculis diam sed gravida scelerisque. Nam at feugiat nulla, sed lacinia erat. Pellentesque nec urna facilisis, hendrerit arcu sed, ullamcorper purus. Praesent vel lorem eget nulla consectetur feugiat ut id tellus. Phasellus a fringilla odio. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Sed nec blandit arcu. Phasellus in lacus dui. Sed volutpat faucibus lectus ut finibus. Pellentesque porta blandit consequat. Suspendisse vitae mattis libero. Ut mattis cursus laoreet.\n" +
            "\n" +
            "Aenean faucibus, erat sit amet vestibulum pulvinar, nulla augue mollis velit, vitae posuere quam ex sed magna. Mauris pharetra neque vel porttitor posuere. Sed in lorem rhoncus, mattis odio in, ultrices augue. Integer et luctus ante. Sed maximus ante eget turpis dictum commodo. Pellentesque in elit eleifend, elementum velit sit amet, molestie elit. Phasellus ut lacus sit amet urna gravida pharetra. Integer lacinia eleifend ante, sit amet venenatis ligula luctus vitae. Duis rhoncus tempus pulvinar. Nulla dignissim pulvinar molestie. In vestibulum mollis eros, non sollicitudin tortor mollis id. Curabitur ac fringilla diam.\n" +
            "\n" +
            "Aliquam erat volutpat. Pellentesque id cursus dolor, nec congue odio. Aenean id tempor massa. Cras a erat a sapien interdum porttitor ac at elit. Nam et luctus eros. Cras velit erat, tempus in commodo at, egestas sed arcu. Etiam elit urna, accumsan finibus orci id, semper hendrerit nisl. Aliquam scelerisque felis quis leo euismod tempor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Duis euismod nulla tortor, vel finibus leo volutpat eget. Ut ut ligula sed neque dictum accumsan eget sed tortor.\n" +
            "\n" +
            "Curabitur convallis leo ante, sodales posuere nisl posuere ultricies. Sed ornare viverra libero. Nunc dignissim elit at dapibus tincidunt. Ut placerat nunc velit, nec blandit arcu consequat lobortis. Cras eget sollicitudin risus. Duis nec risus mollis, fermentum erat nec, malesuada risus. Sed vel rhoncus tellus, sit amet suscipit eros. Nunc eleifend nisl nec ante imperdiet, ut suscipit libero interdum. Ut pharetra odio ac sapien condimentum sagittis. Donec nec orci a diam facilisis efficitur sed nec risus.\n" +
            "\n" +
            "Donec nec mauris cursus, eleifend lectus at, lobortis est. Donec hendrerit lacus nunc, et sollicitudin lectus tincidunt sit amet. Praesent fermentum vestibulum lectus nec pharetra. Aliquam erat volutpat. Vivamus sed neque urna. Phasellus laoreet pharetra tellus vitae commodo. Suspendisse vitae tincidunt diam. Aenean id ante erat. Morbi vitae velit non augue viverra lobortis vel ac dolor. Morbi iaculis purus vitae sem gravida interdum.\n" +
            "\n" +
            "Quisque nec egestas nunc. Nam euismod orci at quam sollicitudin, quis luctus nulla dictum. Cras imperdiet velit in mi scelerisque, nec ullamcorper eros tincidunt. Duis fringilla nisi sed orci vestibulum semper. In ut tortor tincidunt, pharetra urna et, vehicula mi. Aenean interdum arcu sit amet pulvinar pretium. Proin non augue vel tellus vulputate suscipit et eleifend ipsum. Donec dictum vel nibh vitae egestas. Etiam at est iaculis, vehicula mauris eleifend, facilisis metus. Nulla nec mi egestas, laoreet purus quis, rutrum nunc. Ut convallis sagittis nunc, at tincidunt mauris volutpat commodo.\n" +
            "\n" +
            "Sed ornare, justo quis ornare convallis, mi lorem placerat augue, sit amet mollis magna nisl et dolor. Quisque imperdiet risus odio, ut rhoncus libero aliquam in. Mauris consequat dignissim libero sed ultrices. Cras eget ipsum tellus. Donec tortor tellus, eleifend vel nisl ac, faucibus fringilla metus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Duis eget eros vitae quam viverra efficitur nec sit amet nisl. Integer hendrerit nunc tellus, maximus malesuada ex pellentesque finibus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum ornare, magna vitae ultricies sagittis, ex massa blandit mauris, in ultricies sapien dui mattis dui. Phasellus nec libero facilisis, facilisis purus rutrum, sodales felis. Mauris feugiat porta orci vel ornare.\n" +
            "\n" +
            "Vestibulum ut imperdiet ex. Nullam auctor tristique mi, a congue quam venenatis sed. Nunc convallis augue nec quam fringilla, eget dapibus diam malesuada. Donec fringilla cursus tortor non facilisis. Fusce augue libero, commodo consequat lacus vestibulum, tristique aliquam neque. Integer eu tincidunt dui. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam venenatis leo a magna facilisis congue. Nullam condimentum vitae justo eu efficitur. Cras molestie pharetra faucibus. Etiam vel nibh orci. Nulla ornare euismod consequat. Integer et libero rutrum, volutpat est eu, mattis arcu. Aenean malesuada mi ut faucibus cursus. Vestibulum ultricies erat tristique, mollis eros in, tristique ipsum. Etiam sed tortor eu arcu egestas egestas id id mauris.\n" +
            "\n" +
            "Proin finibus eros id malesuada aliquam. Aenean suscipit bibendum magna nec commodo. Vivamus vel orci volutpat, placerat est non, faucibus dui. Curabitur commodo augue non magna suscipit, at iaculis justo sollicitudin. In vitae ex a velit laoreet convallis a nec tellus. Vivamus dictum dui ac quam mollis, non gravida tellus consectetur. Vestibulum finibus molestie tempus. Aliquam mattis commodo ligula, ac tempus urna tempor et. Praesent feugiat consectetur condimentum. Aenean faucibus orci ut libero dictum, id lobortis dui convallis. Sed luctus venenatis nisl a scelerisque. Nulla fermentum ultrices lacus non porta. Pellentesque vulputate fermentum eros nec sodales. Aliquam pulvinar nisl purus, sed bibendum nisl feugiat nec. Vivamus porttitor risus sit amet orci mattis, ultricies volutpat velit pulvinar. Vivamus volutpat elementum mauris, a ultricies leo rutrum et.\n" +
            "\n" +
            "Integer sodales felis id lectus interdum vulputate. In hac habitasse platea dictumst. Vivamus accumsan elementum vulputate. Suspendisse potenti. Fusce tortor velit, venenatis sed imperdiet efficitur, lacinia vitae felis. Aliquam sit amet leo cursus, interdum purus a, ullamcorper urna. In quam justo, hendrerit sit amet eleifend quis, consequat eget lacus. Etiam finibus, dolor nec suscipit eleifend, purus urna accumsan nulla, a finibus quam tellus sit amet dui. Suspendisse lacinia, ex vitae tempus porttitor, diam ex dapibus augue, a elementum orci felis ac ante. Proin at luctus nunc. Etiam a ultrices sem, ut placerat ante.\n" +
            "\n" +
            "Maecenas orci lorem, molestie et neque vitae, efficitur molestie dolor. Duis in ullamcorper nisl, auctor faucibus mi. Praesent nec consequat lorem. Nulla id dolor efficitur, condimentum erat a, molestie nibh. Vivamus commodo mi velit, et hendrerit sem commodo eu. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer consectetur, libero ac hendrerit lacinia, orci justo ullamcorper nisl, at consectetur odio dolor ac quam. Suspendisse sed sem lacus. Donec elit justo, lobortis sed ex a, ornare sodales nunc. Morbi mauris augue, volutpat eget nisi id, luctus hendrerit eros. Morbi vel sagittis nisl. Sed pretium hendrerit elementum. Nullam posuere vestibulum mattis.\n" +
            "\n" +
            "In in porta lacus. Aliquam turpis massa, elementum ac tempus at, rhoncus sit amet ante. In pulvinar venenatis metus sit amet dignissim. Quisque ac risus ac felis vestibulum feugiat. Nullam malesuada nulla at est vulputate semper nec nec nisl. Pellentesque quis sodales eros. In sit amet nisl odio.\n" +
            "\n" +
            "Mauris turpis nunc, venenatis convallis lacinia in, pretium nec elit. Nulla turpis augue, consequat nec vestibulum non, maximus sed enim. Maecenas sed eros non ex ultrices pretium et ut purus. Nulla fringilla sapien rutrum velit fermentum, vulputate ultricies urna euismod. Aliquam vel libero eget enim ultrices condimentum quis in enim. Quisque mattis, nunc non dignissim sollicitudin, ante velit venenatis arcu, ut scelerisque tortor nulla nec sapien. Suspendisse ac aliquam ligula. In a pulvinar est, vel pulvinar justo.\n" +
            "\n" +
            "Praesent lacinia interdum quam, non faucibus lacus pretium vestibulum. Mauris commodo neque id justo venenatis, ac porttitor metus sagittis. Mauris sit amet elit ultricies, aliquam ipsum in, eleifend metus. Curabitur tempus augue ac dui tincidunt ultricies. Fusce eget turpis eget massa commodo tempus vitae in erat. In sollicitudin eros lorem, id egestas nibh porttitor sit amet. Etiam auctor, erat ut tempus dictum, metus magna dictum nunc, et hendrerit lacus lorem eget libero. Nullam eget leo porttitor eros venenatis tincidunt et vel purus. Sed ultricies maximus ex, et ullamcorper urna sagittis sed.\n" +
            "\n" +
            "Pellentesque non enim leo. Curabitur non tristique mi. Nam id orci tempus, aliquet erat quis, mattis purus. Vivamus a metus vel est suscipit suscipit. Nam maximus gravida mauris, fringilla semper leo scelerisque laoreet. Donec congue quis ipsum ac dictum. Nunc euismod mauris tortor. Suspendisse pharetra lectus feugiat ipsum lobortis dapibus. Mauris ullamcorper facilisis arcu placerat aliquet. Sed scelerisque varius ligula, quis suscipit orci iaculis aliquet. Integer sed nibh blandit, euismod nisi at, placerat ex. Sed nec ligula augue. Pellentesque quis ex dui. Phasellus eu imperdiet sem, at faucibus mauris.\n" +
            "\n" +
            "Maecenas eu venenatis enim, ac gravida nisi. Quisque pharetra nunc vitae lacus ornare efficitur. Sed sit amet tellus dignissim, scelerisque elit at, ornare felis. Donec porta vestibulum est iaculis consectetur. Etiam mollis dictum odio sed convallis. Ut laoreet, elit vel pulvinar viverra, felis est dictum eros, eu iaculis eros metus at diam. Morbi ornare quis ante in ultrices. Vestibulum auctor lorem at orci aliquam, ut vestibulum arcu luctus. Nunc eget sollicitudin dolor. Quisque auctor augue et justo porttitor, ut tempus massa hendrerit. Praesent eleifend ac augue ut porttitor. Fusce non felis ac lorem tempus elementum.\n" +
            "\n" +
            "Maecenas sit amet pellentesque mauris, sed finibus nunc. Morbi nibh lorem, ullamcorper a dui sit amet, facilisis dapibus nisi. Vestibulum tempus vel ligula sed tempor. Duis blandit, sapien vitae ornare pulvinar, est quam cursus magna, sed pharetra urna nisi eget augue. Vestibulum pharetra luctus mauris ac lobortis. Cras vulputate purus in tincidunt eleifend. Morbi ullamcorper euismod interdum. Morbi congue euismod arcu, quis aliquet dolor vehicula et. Donec ullamcorper urna ut lectus fermentum sagittis. Quisque leo justo, auctor in est vitae, fringilla semper nibh. Praesent ornare sem magna, eu lobortis enim luctus quis. Proin ullamcorper dui ut nunc viverra vehicula.\n" +
            "\n" +
            "Nunc tempor neque dictum nisi venenatis, sit amet ultrices ex pellentesque. Donec rhoncus risus ac turpis tempus rutrum. Proin pellentesque ullamcorper congue. Nam nec nibh eget purus ullamcorper efficitur. Integer nunc diam, viverra ut feugiat a, volutpat nec erat. Curabitur ut tellus lacinia, ultricies dui a, rutrum tortor. Integer at mauris vel nunc vehicula rhoncus ut quis ex. Donec eget eleifend magna, vitae tincidunt turpis. Nullam in vulputate neque, in mattis sem. Proin rhoncus euismod libero eu tincidunt. Proin viverra lectus ut velit scelerisque, a vehicula orci condimentum. Maecenas aliquam lorem ac lectus dapibus vestibulum at vulputate ligula. Suspendisse condimentum ante nunc, nec vehicula justo lobortis et. Proin a tortor porta, sollicitudin enim vitae, hendrerit lorem.\n" +
            "\n" +
            "Ut commodo enim non bibendum viverra. Nunc fermentum dignissim pellentesque. Cras elementum tortor nisl. Mauris ultrices ultricies ligula sit amet condimentum. In hac habitasse platea dictumst. Nam in magna eget enim lacinia consectetur. Sed placerat ullamcorper nisl. Mauris cursus in ante at interdum. Mauris cursus velit facilisis, pretium metus tincidunt, congue nunc. Proin lobortis lobortis nisl.\n" +
            "\n" +
            "Proin arcu tellus, placerat ac est at, auctor finibus turpis. Vestibulum interdum ac lorem in pretium. Morbi et orci semper, placerat turpis in, auctor elit. Etiam placerat dui et est facilisis, ac interdum mi viverra. Pellentesque consequat orci vel nisi porta, et feugiat massa ullamcorper. Nullam quam nisl, imperdiet non turpis quis, dignissim aliquet lectus. Fusce ac pretium nisi. In elementum porta risus, iaculis varius urna luctus vitae. Sed eleifend iaculis lorem, nec imperdiet massa consectetur vitae. Vivamus ullamcorper mauris non leo gravida facilisis. Donec elementum nisl nibh, ac congue dui pellentesque vitae.\n" +
            "\n" +
            "Duis id maximus ex. Proin fermentum diam id varius suscipit. Nulla vel vehicula justo. Donec pretium feugiat orci vel vestibulum. Donec quis augue euismod, fermentum orci efficitur, ornare sem. In dapibus tempus elementum. Proin blandit leo purus, vel tincidunt urna bibendum eget. Phasellus sagittis nunc quis enim consectetur egestas. Curabitur viverra vestibulum dapibus. Cras quis molestie arcu. Duis sapien turpis, consequat sit amet nibh vel, ullamcorper pellentesque tortor. Mauris felis sem, efficitur at elementum elementum, malesuada nec nisl. Vivamus nec tincidunt quam, et pretium ex. Aenean condimentum nibh sit amet molestie aliquet. Nam sollicitudin pretium lorem non euismod.\n" +
            "\n" +
            "Nullam elementum dolor id ullamcorper mollis. Nunc volutpat lacinia odio sit amet vulputate. Nunc tempus, elit eu suscipit semper, turpis odio rhoncus nisi, ut vestibulum lectus tortor imperdiet eros. Aenean tristique est at elit aliquet sodales. Ut vehicula arcu tempor luctus dignissim. Proin condimentum orci accumsan mattis facilisis. Duis tincidunt dolor sit amet nunc aliquet mattis. Fusce vel libero ante. Suspendisse potenti. Phasellus eleifend hendrerit convallis. Cras pretium, orci vitae varius sodales, ligula quam faucibus nunc, a egestas lectus sapien in est. Ut nec imperdiet ipsum. Aenean vestibulum libero vel sapien molestie suscipit. Curabitur eu ex quis velit porta luctus.\n" +
            "\n" +
            "Sed massa nibh, iaculis ac felis semper, ultrices sodales justo. Nulla ut risus velit. Vestibulum id consectetur arcu. Curabitur nulla dui, fringilla vitae iaculis vel, accumsan at neque. Aenean convallis leo ligula, quis lacinia lorem venenatis eget. Fusce laoreet eu leo finibus ultrices. Ut malesuada sit amet nibh eget scelerisque. Donec sollicitudin dolor non sapien dignissim lobortis. Vestibulum vitae augue purus. Curabitur efficitur, sem molestie consectetur ultrices, quam leo mollis lacus, vitae euismod nisl quam id leo. Phasellus accumsan posuere mauris id feugiat. In cursus orci quis turpis mattis vulputate. Cras ac urna velit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
            "\n" +
            "Donec eu ultricies neque. Mauris sodales, ante nec rutrum eleifend, dolor eros interdum nulla, a vehicula nibh purus quis eros. Sed quis augue sed elit euismod efficitur ut vitae dui. Maecenas convallis risus purus, non facilisis neque varius ac. Maecenas finibus, ligula vel finibus consequat, lacus augue porta magna, vitae auctor nisi libero a metus. Quisque tempor nisl nulla, sit amet aliquet purus imperdiet sed. Ut consequat tellus est, non venenatis justo tincidunt eu. Ut sit amet malesuada ante, eu venenatis massa. Nam molestie nisi quis ligula sodales, eu rutrum erat luctus. Nulla et vulputate augue. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque mollis venenatis purus ac lacinia. Mauris eget efficitur elit. Nunc nec cursus ipsum. Phasellus sem felis, porttitor ac gravida et, dapibus at sapien.\n" +
            "\n" +
            "Ut congue, dui quis dapibus pretium, ex ipsum efficitur mi, at molestie erat lectus non erat. Praesent posuere malesuada nulla at molestie. Donec pharetra id eros nec aliquet. Curabitur magna elit, placerat id auctor et, tempor in urna. Nam sed lacinia diam, quis mattis leo. Praesent at eros condimentum, rutrum dolor quis, condimentum diam. Curabitur vel quam ipsum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce fringilla libero eros, vitae convallis nisl dapibus eget. In hac habitasse platea dictumst. In vel finibus purus. Sed sit amet odio nibh. Curabitur tincidunt scelerisque erat, quis facilisis dui feugiat ac. Aliquam a nisl eu ante venenatis imperdiet.\n" +
            "\n" +
            "Morbi lobortis dapibus nulla. Nulla facilisi. Vestibulum id mi sit amet tortor euismod commodo in at diam. Curabitur sapien ipsum, bibendum sit amet condimentum eu, congue non libero. Nam quis ligula eleifend, rutrum erat vel, facilisis est. Morbi quis tortor viverra, condimentum est sit amet, ornare lectus. Praesent fermentum id risus id molestie. Donec lacinia sodales magna. Cras in urna vulputate, feugiat nunc eget, tempus nisl. Etiam tristique tellus urna, nec rutrum metus imperdiet sed. Praesent nec sapien et lectus porta convallis.\n" +
            "\n" +
            "Donec consectetur lacus nec pulvinar vulputate. Nunc aliquam elit in felis interdum, a placerat ex fermentum. Nulla auctor lobortis orci ut fringilla. Praesent at dapibus felis, at mollis urna. Nulla pulvinar libero vitae tellus auctor, sed posuere mauris rhoncus. Mauris bibendum semper rhoncus. Suspendisse potenti. Sed porta nisi urna. Vivamus odio sapien, luctus eget aliquam eu, porta vel purus. Quisque ut nibh sit amet mi venenatis mollis ac et velit. Donec consectetur felis in vestibulum facilisis. Duis vitae tempus orci. Phasellus nisl nisi, ultrices sit amet mattis ac, consectetur a ipsum. Nulla tempor rutrum lectus, id congue diam vestibulum nec.\n" +
            "\n" +
            "Curabitur at odio mattis, porta mauris eu, lacinia tellus. Nunc accumsan lorem dui, fermentum vehicula nulla lacinia vel. Phasellus at libero sed purus vestibulum elementum. Pellentesque imperdiet odio metus, a rutrum lectus scelerisque congue. Mauris et ex eleifend, convallis ex at, sodales ligula. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse eu eros sollicitudin, suscipit sem id, vehicula est. In rhoncus justo metus, eget gravida nunc lacinia non. Quisque a euismod erat. Aliquam lacinia aliquet sollicitudin. Curabitur nec quam ex.\n" +
            "\n" +
            "In eu libero eu dolor consectetur elementum. Vivamus vel dignissim odio. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Duis fringilla ante massa. Pellentesque ac justo tincidunt, dignissim arcu eget, volutpat sem. Phasellus rhoncus sed nibh ut vehicula. Donec suscipit magna et augue dictum molestie. Integer condimentum tellus dui, ut facilisis arcu consectetur quis. In scelerisque augue risus, quis tristique augue suscipit iaculis. Nunc nec erat et velit fringilla tincidunt. Praesent sollicitudin massa eros, eget varius turpis interdum eu.\n" +
            "\n" +
            "Suspendisse varius vulputate ornare. In non purus quis urna eleifend feugiat. Ut iaculis odio metus, quis lacinia diam finibus volutpat. Aenean consequat dictum dui, at interdum arcu sodales pretium. Aliquam lacinia suscipit lacus in semper. Proin sit amet augue nec lacus mattis efficitur id eu libero. Integer rhoncus suscipit malesuada. Morbi in turpis ut nunc ultrices vulputate sit amet non nisi. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Ut accumsan et dolor eu venenatis. Integer dapibus et leo eu faucibus. Nulla et est semper, consectetur metus ac, porttitor leo. Curabitur pharetra non dolor id vulputate. Aenean vestibulum tempus nulla, ac sodales dolor consequat in. Sed eu leo fringilla, pharetra nibh in, aliquet augue.\n" +
            "\n" +
            "Nulla consequat, eros a eleifend sollicitudin, dui magna accumsan sapien, at iaculis tortor nisl sit amet velit. Suspendisse vitae metus consequat quam hendrerit congue a in lorem. Ut sodales id nulla non molestie. Quisque hendrerit nunc et volutpat posuere. Cras sit amet lacus eget tortor fermentum scelerisque. Aliquam et fermentum ipsum. Donec id ex pellentesque, pharetra purus at, ullamcorper erat. Nam orci leo, varius ac odio eget, tincidunt rutrum justo. Nulla bibendum, diam quis tempor pretium, lacus odio tempor mauris, eu mollis quam diam rhoncus tortor. Integer lobortis nunc sapien, finibus euismod ipsum molestie vitae. Ut ullamcorper faucibus urna, sit amet efficitur velit pretium nec. Duis bibendum ipsum orci, in efficitur ipsum ornare a. Proin vitae mauris consequat, semper nisi eget, consequat lacus.\n" +
            "\n" +
            "Nulla ut dolor tincidunt, efficitur lectus dictum, auctor purus. Sed vitae posuere purus. Nullam commodo ultricies lorem id ullamcorper. Aenean pellentesque augue eget vestibulum ornare. Vestibulum consectetur ut felis sed interdum. Sed aliquam, orci vitae tincidunt sodales, diam magna malesuada velit, eget vehicula mi leo in leo. Suspendisse mattis vitae lectus ut congue. Vivamus vitae dapibus mi, eget dictum urna. Ut pretium elit eget ex porttitor tempus. Aliquam pellentesque, lectus sed luctus vestibulum, sapien quam lacinia sapien, quis pulvinar diam nisl et ante. In turpis nunc, finibus volutpat posuere id, volutpat nec enim. Quisque posuere, enim elementum eleifend iaculis, erat magna interdum mauris, nec ultricies libero sapien eu est. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\n" +
            "\n" +
            "Sed lacus massa, sodales eget nisl ut, venenatis vulputate metus. Duis faucibus bibendum scelerisque. Duis fringilla sollicitudin tincidunt. Etiam eu eros nec urna porttitor tincidunt in lacinia massa. Aenean scelerisque elit a sapien fermentum laoreet. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi tempor non nisl vitae tempor. Donec id eros velit. Integer commodo, velit in fermentum semper, lorem odio pulvinar augue, id consectetur sem turpis vel massa. Curabitur turpis velit, eleifend vitae tincidunt nec, tempus id libero.\n" +
            "\n" +
            "Donec semper tempor nibh nec varius. Nam ornare velit lorem, ac suscipit massa pellentesque eget. Sed quis lorem eros. Mauris interdum elit vitae libero ullamcorper convallis. Aliquam neque tortor, accumsan ac viverra et, rhoncus ac augue. Aenean ultrices sollicitudin orci in efficitur. Aliquam erat volutpat. Nulla arcu augue, porttitor vel facilisis sed, vestibulum in quam. Aenean vitae nunc quis metus tristique vehicula non et elit. Praesent sit amet mollis ante. Aenean aliquet et mi nec consequat. Nulla vehicula odio justo, eget convallis ex blandit eget. Sed vitae lorem orci. Vestibulum sit amet tellus pellentesque, eleifend erat at, auctor tellus. Vivamus ullamcorper quam odio, sed elementum nunc sodales quis. Quisque malesuada quis diam non bibendum.\n" +
            "\n" +
            "Vestibulum tincidunt dolor id augue tempus pretium. Aenean elementum leo vel metus condimentum molestie. Fusce ut hendrerit sapien. Vestibulum et elit quis sem mattis vulputate vitae nec nisi. Aliquam erat volutpat. Suspendisse fringilla risus nisi, non maximus lorem suscipit sed. Suspendisse a risus risus. Vestibulum nisi sapien, facilisis et vestibulum a, porta id ex.\n" +
            "\n" +
            "Ut venenatis, nunc eget volutpat scelerisque, mauris urna fermentum ex, a egestas mi lacus eget urna. Cras rhoncus egestas placerat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In at velit tristique, malesuada ex eu, tempus tortor. Aliquam ante orci, dapibus vitae lacinia a, dictum ut quam. Quisque convallis ipsum cursus mi auctor aliquam. Cras ligula ipsum, vulputate eget condimentum quis, pulvinar sed orci. Suspendisse scelerisque quis nisi quis tempor. Morbi non risus est. Nunc sed sollicitudin augue. Phasellus sed hendrerit enim, id egestas dui. Suspendisse quis ante turpis. Etiam varius vitae ex quis egestas. Phasellus leo nunc, placerat id eros id, sagittis tincidunt eros. Maecenas tincidunt ac mi sed vulputate.\n" +
            "\n" +
            "Sed fermentum felis nec turpis hendrerit egestas. Curabitur ac iaculis libero. Curabitur rutrum vel risus at blandit. Nam tincidunt quam vitae risus ultricies, nec consectetur turpis semper. Etiam scelerisque, purus a gravida feugiat, felis tellus dapibus magna, vel commodo nibh risus sed tellus. In congue auctor quam quis consequat. Quisque rhoncus vel diam ut fermentum.\n" +
            "\n" +
            "Mauris at velit luctus, dapibus ipsum vitae, convallis nisi. Nullam pellentesque, sem non accumsan accumsan, nunc massa pulvinar sapien, ut volutpat nisi orci ac est. Sed gravida eros leo, a dictum mauris gravida ac. Nam eleifend elementum magna nec viverra. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam commodo libero vel aliquet pulvinar. Etiam laoreet suscipit ex, ut porta ligula tincidunt sed. Maecenas ut sem diam.\n" +
            "\n" +
            "In iaculis neque at faucibus vulputate. Nam consectetur nunc non erat mattis, nec molestie nisl vestibulum. Proin et urna in dolor venenatis tristique. Mauris tristique a lectus tincidunt pretium. Donec fringilla est eget metus varius, vitae efficitur nisi bibendum. Vestibulum euismod eget sem non pellentesque. Nullam in ipsum nulla. Proin ut risus in mi bibendum ullamcorper malesuada eu est. Aliquam tristique nisl eget sagittis iaculis. Cras a libero libero.\n" +
            "\n" +
            "Nullam tincidunt auctor leo ac efficitur. Vivamus arcu turpis, sollicitudin quis turpis vel, vestibulum fringilla nunc. Pellentesque consequat felis eu velit pellentesque pellentesque. Suspendisse commodo interdum congue. Cras lacus felis, suscipit at eleifend sit amet, pellentesque sit amet mi. Aliquam erat volutpat. Cras posuere libero arcu, ut mattis ante blandit non. Etiam egestas metus sit amet fringilla fringilla. Phasellus dignissim orci ac ipsum gravida accumsan. Phasellus id efficitur ante. Praesent bibendum magna dolor, in vestibulum lacus molestie a. Praesent aliquam lectus quis dui vulputate lacinia. Nunc imperdiet auctor venenatis. Nullam tempor eu purus ut iaculis.\n" +
            "\n" +
            "Phasellus tincidunt sed tellus ac tristique. Etiam at rutrum ante. Sed placerat congue elit non porta. Ut molestie augue in dolor sollicitudin pellentesque vel ac mauris. Morbi scelerisque neque mauris, in convallis arcu ultrices id. In accumsan erat sem, et consectetur augue posuere vitae. Integer vestibulum metus nunc, eget feugiat augue venenatis vel. Nullam metus neque, pharetra non nisi ut, egestas sollicitudin sapien. Sed tempor sem sed risus cursus condimentum. Donec congue, odio vel egestas mollis, odio tortor mollis risus, ac ultricies ante justo eu tortor. Mauris laoreet nibh non arcu condimentum, ac dapibus neque porta.\n" +
            "\n" +
            "Pellentesque et dapibus enim. Curabitur dapibus elit leo, eu luctus felis ullamcorper vulputate. Pellentesque sit amet tortor ac elit consequat ultrices sed ut diam. Duis sodales leo et odio varius elementum. Vestibulum justo orci, vehicula ullamcorper nulla id, venenatis consectetur diam. Aliquam placerat sit amet lorem nec euismod. Donec id tincidunt tellus, nec tincidunt dui. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Sed convallis eros sed luctus posuere. Ut eu vestibulum felis. Mauris at luctus sem. Duis a urna id ante ullamcorper pulvinar eu ac ex. Proin quis orci faucibus, suscipit ex eget, sollicitudin nisi. Aliquam accumsan in purus elementum auctor. Nulla facilisi. Pellentesque nulla massa, accumsan nec quam eu, dignissim accumsan metus.\n" +
            "\n" +
            "Pellentesque tincidunt vestibulum ornare. Vivamus laoreet malesuada dui eget venenatis. Donec fringilla, tortor at sagittis viverra, erat felis fermentum nibh, ultricies faucibus velit dui eget lacus. Aenean quis tristique purus. Sed vel massa sagittis, molestie lectus id, ultrices enim. Proin id dolor suscipit, laoreet augue vel, faucibus justo. Sed interdum metus non accumsan varius. Nunc non massa eget risus imperdiet interdum porta at lacus. Aliquam erat volutpat. Cras facilisis condimentum ex in molestie. Nunc a leo faucibus, semper augue a, euismod nibh. Phasellus a velit leo.\n" +
            "\n" +
            "Nunc id risus quis justo fringilla sagittis. Sed vel volutpat purus, quis sagittis odio. Nunc scelerisque, mauris non sollicitudin semper, nisl mauris vehicula odio, at dictum dui quam id felis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Phasellus vulputate luctus quam vestibulum vestibulum. Aenean at lacus odio. Pellentesque blandit vehicula tempus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras elementum hendrerit ornare. Nam viverra ex tortor, nec vestibulum turpis venenatis nec. Mauris rhoncus leo nec metus efficitur, nec sagittis lectus consectetur. Morbi faucibus sollicitudin lacus euismod placerat.\n" +
            "\n" +
            "Integer fermentum finibus posuere. Nulla ut felis pellentesque, convallis justo ut, suscipit mi. Pellentesque nec imperdiet risus. In nibh nunc, molestie vitae lorem id, eleifend euismod lorem. Pellentesque turpis diam, placerat nec massa vitae, sodales consectetur nunc. Nulla id cursus libero, sit amet iaculis urna. Ut venenatis libero vitae finibus fringilla. Curabitur sed ante condimentum, feugiat lorem ut, ultrices neque. Suspendisse posuere, dolor sed lobortis venenatis, nisi diam porta risus, ut ornare nulla massa a orci. Proin lorem mi, accumsan in venenatis non, bibendum nec neque. Praesent sed nulla justo. In gravida enim in dui rutrum egestas. In rutrum ligula purus, at cursus quam auctor vitae. Curabitur nibh justo, accumsan eget dignissim sed, viverra sit amet dui.\n" +
            "\n" +
            "Nullam sollicitudin dignissim urna, vitae laoreet dolor. Donec at auctor risus. Ut porta ornare urna, eu accumsan erat varius id. Nunc ornare nunc id rhoncus euismod. Etiam est turpis, dictum vel iaculis a, sagittis vitae nisl. Sed id condimentum eros. Pellentesque et rutrum neque, at vehicula nunc. Integer dictum sapien ante, vitae ultricies ex facilisis et.\n" +
            "\n" +
            "Aliquam rhoncus dolor eget ligula dignissim pulvinar. Etiam magna leo, auctor eget sagittis a, convallis vitae tellus. Nullam sollicitudin molestie erat vel finibus. Aenean id ligula a dui pulvinar suscipit. Proin dictum purus sed purus ultrices mattis. Curabitur id lacinia erat, in dignissim dui. Nullam sagittis nisl at nisl cursus lobortis. Vestibulum aliquam purus vitae odio facilisis dignissim ullamcorper eu orci. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin id arcu velit. Pellentesque maximus at justo vitae elementum. Phasellus eget mollis sapien.";

    public static void main(String[] args) {
        int keywordCount = 10000000;
        List<String> keywords = generateKeywords(keywordCount);

        System.out.println("본문 길이 = " + CONTENT.length());

        System.out.println("32,062글자에서 1억개 키워드 찾기");
        // 생성된 키워드 확인
        long millis = System.currentTimeMillis();
        // 1억개 키워드중 CONTENT에 포함되어있는것 filter (병렬 X)
        List<String> filteredKeywords = keywords.stream()
                .filter(CONTENT::contains)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("filteredKeywords.size() = " + filteredKeywords.size());
        System.out.println("걸린 시간: " + (System.currentTimeMillis() - millis) + "ms");

        System.out.println("--------------------------------------------------------");

        System.out.println("병렬로 32,062글자에서 1억개 키워드 찾기");
        // 생성된 키워드 확인
        millis = System.currentTimeMillis();
        // 1억개 키워드중 CONTENT에 포함되어있는것 filter 병렬
        filteredKeywords = keywords.parallelStream()
                .filter(CONTENT::contains)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("filteredKeywords.size() = " + filteredKeywords.size());
        System.out.println("걸린 시간: " + (System.currentTimeMillis() - millis) + "ms");

        System.out.println("--------------------------------------------------------");

        System.out.println("챗지피티 버전 병렬로 32,062글자에서 1억개 키워드 찾기");
        millis = System.currentTimeMillis();
        // 1억개 키워드 중 CONTENT에 포함되어 있는 것 필터링 (KMP 알고리즘 사용)
        filteredKeywords = keywords.parallelStream()
                .filter(keyword -> isKeywordContained(keyword, CONTENT))
                .collect(Collectors.toList());

        System.out.println("filteredKeywords.size() = " + filteredKeywords.size());
        System.out.println("걸린 시간: " + (System.currentTimeMillis() - millis) + "ms");
    }

    // KMP 알고리즘을 위한 접두사 배열(Prefix Table) 생성 함수
    public static int[] buildPrefixTable(String pattern) {
        int[] prefixTable = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                prefixTable[i] = j + 1;
                j++;
            } else {
                if (j != 0) {
                    j = prefixTable[j - 1];
                    i--;
                } else {
                    prefixTable[i] = 0;
                }
            }
        }
        return prefixTable;
    }

    // KMP 알고리즘을 사용하여 키워드가 CONTENT에 포함되는지 확인하는 함수
    public static boolean isKeywordContained(String keyword, String content) {
        int[] prefixTable = buildPrefixTable(keyword);
        int i = 0, j = 0;
        while (i < content.length() && j < keyword.length()) {
            if (content.charAt(i) == keyword.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = prefixTable[j - 1];
                } else {
                    i++;
                }
            }
        }
        return j == keyword.length();
    }

}


class KeywordGenerator {
    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ -";

    public static List<String> generateKeywords(int count) {
        Set<String> keywordSet = new HashSet<>();
        Random random = new Random();

        while (keywordSet.size() < count) {
            int length = random.nextInt(100) + 1;
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < length; j++) {
                int index = random.nextInt(CHARSET.length());
                char c = CHARSET.charAt(index);
                sb.append(c);
            }

            keywordSet.add(sb.toString());
        }

        return new ArrayList<>(keywordSet);
    }
}

