package compgc01;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BookController implements Initializable {

    Label title;
    Label screen,one,two,three,four,five,six,seven,eight,nine,ten;
    Label f1,f2;
    Label movie,time,tickets,total,seats,movie_ans,time_ans,tickets_ans,total_ans,seats_ans,available,sold,selected;
    Button book,b_available,b_sold,b_selected;

    Button r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9,r1c10;
    Button r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9,r2c10;
    Button r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8;
    Button r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9,r5c10;
    Button r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9,r6c10;
    Button r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9,r7c10;
    Button r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9,r8c10;
    Button r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9,r9c10;
    Button r10c3,r10c4,r10c5,r10c6,r10c7,r10c8;

    String grey = "-fx-background-color:#B2BEB5";
    String green = "-fx-background-color:#32CD32";

    String[] btn = {"r1c1","r1c2","r1c3","r1c4","r1c5","r1c6","r1c7","r1c8","r1c9","r1c10","r2c1","r2c2","r2c3","r2c4","r2c5","r2c6","r2c7","r2c8","r2c9","r2c10","r4c1","r4c2","r4c3","r4c4","r4c5","r4c6","r4c7","r4c8","r5c1","r5c2","r5c3","r5c4","r5c5","r5c6","r5c7","r5c8","r5c9","r5c10","r6c1","r6c2","r6c3","r6c4","r6c5","r6c6","r6c7","r6c8","r6c9","r6c10","r7c1","r7c2","r7c3","r7c4","r7c5","r7c6","r7c7","r7c8","r7c9","r7c10","r8c1","r8c2","r8c3","r8c4","r8c5","r8c6","r8c7","r8c8","r8c9","r8c10","r9c1","r9c2","r9c3","r9c4","r9c5","r9c6","r9c7","r9c8","r9c9","r9c10","r10c3","r10c4","r10c5","r10c6","r10c7","r10c8"};
    String[] btn_clr = {grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey};
    Button[] all_btn = {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9,r1c10,r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9,r2c10,r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9,r5c10,r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9,r6c10,r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9,r7c10,r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9,r8c10,r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9,r9c10,r10c3,r10c4,r10c5,r10c6,r10c7,r10c8};
    Button[] selected_btn = new Button[84];

    String seats_val = "";
    int ticket = 0;
    int amount = 0;
    int count = 0;

    String clr;

    /**
     * This method used to appear gui different colors in buttons
     * @param b is selected button
     * @param indx is index of button
     */
    public void setDisplay(Button b, int indx){
        //get current color of button
        clr = btn_clr[indx];
        //if button is grey colored, then goes to this statement
        //this statement used to order a seat
        if(clr==grey){
            b.setStyle(green);
            btn_clr[indx] = green;
            ticket++;
            if(indx<78){
                amount+=12;
                total_ans.setText(": $ "+amount);
            }
            //in last row seat should 20 $
            else{
                amount+=20;
                total_ans.setText(": $ "+amount);
            }
            tickets_ans.setText(": "+ticket);
            selected_btn[indx] = b;
            seats_val = ": ";
            for(int i=0;i<84;i++){
                if(selected_btn[i]!=null){
                    seats_val+=(btn[i]+" ");
                }
            }
            seats_ans.setText(seats_val);
        }
        //if button color is green, go to this statement
        //this statement used to remove order
        else if(clr==green){
            b.setStyle(grey);
            btn_clr[indx] = grey;
            ticket--;
            if(indx<78){
                amount-=12;
                total_ans.setText(": $ "+amount);
            }
            //in last row seat should 20 $
            else{
                amount-=20;
                total_ans.setText(": $ "+amount);
            }
            tickets_ans.setText(": "+ticket);
            selected_btn[indx] = null;
            seats_val = ": ";
            for(int i=0;i<84;i++){
                if(selected_btn[i]!=null){
                    seats_val+=(btn[i]+" ");
                }
            }
            seats_ans.setText(seats_val);
        }

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //design title
        title = new Label("Multiplex Theatre Showing Screen1");
        title.setPrefSize(500,80);
        title.setAlignment(Pos.CENTER);
        title.setFont(new Font("Lucida Sans Unicode",25));

        //design screen label
        screen = new Label("SCREEN");
        screen.setStyle("-fx-background-color: #FFA500");
        screen.setPrefSize(348,35);
        screen.setAlignment(Pos.CENTER);
        screen.setFont(new Font("Verdana",15));
        screen.setTextFill(Color.rgb(255,255,255));
        f1 = new Label("");
        f1.setPrefSize(15,35);

        int[] label_btn = {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,3,4,5,6,7,8};

        //design buttons in initially
        for(int i = 0; i<84; i++){
            all_btn[i] = new Button(label_btn[i]+"");
            all_btn[i].setPrefSize(30,35);
            all_btn[i].setStyle(grey);
            all_btn[i].setTextFill(Color.rgb(255,255,255));
        }

        one = new Label("1");
        one.setPrefSize(15,35);

        two = new Label("2");
        two.setPrefSize(15,35);

        three = new Label("3");
        three.setPrefSize(10,15);

        four = new Label("4");
        four.setPrefSize(15,35);

        five = new Label("5");
        five.setPrefSize(15,35);

        six = new Label("6");
        six.setPrefSize(15,35);

        seven = new Label("7");
        seven.setPrefSize(15,35);

        eight = new Label("8");
        eight.setPrefSize(15,35);

        nine = new Label("9");
        nine.setPrefSize(15,35);

        ten = new Label("10");
        ten.setPrefSize(15,35);
        f2 = new Label(" ");
        f2.setPrefSize(65,35);

        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        HBox hb4 = new HBox();
        HBox hb5 = new HBox();
        HBox hb6 = new HBox();
        HBox hb7 = new HBox();
        HBox hb8 = new HBox();
        HBox hb9 = new HBox();
        HBox hb10 = new HBox();

        //grouping rows
        hb1.getChildren().addAll(one,all_btn[0],all_btn[1],all_btn[2],all_btn[3],all_btn[4],all_btn[5],all_btn[6],all_btn[7],all_btn[8],all_btn[9]);
        hb1.setSpacing(5);
        hb1.setPadding(new Insets(5,5,5,20));

        hb2.getChildren().addAll(two,all_btn[10],all_btn[11],all_btn[12],all_btn[13],all_btn[14],all_btn[15],all_btn[16],all_btn[17],all_btn[18],all_btn[19]);
        hb2.setSpacing(5);
        hb2.setPadding(new Insets(5,5,5,20));

        hb3.getChildren().add(three);
        hb3.setSpacing(5);
        hb3.setPadding(new Insets(5,45,5,20));

        hb4.getChildren().addAll(four,all_btn[20],all_btn[21],all_btn[22],all_btn[23],all_btn[24],all_btn[25],all_btn[26],all_btn[27]);
        hb4.setSpacing(5);
        hb4.setPadding(new Insets(5,45,5,20));

        hb5.getChildren().addAll(five,all_btn[28],all_btn[29],all_btn[30],all_btn[31],all_btn[32],all_btn[33],all_btn[34],all_btn[35],all_btn[36],all_btn[37]);
        hb5.setSpacing(5);
        hb5.setPadding(new Insets(5,45,5,20));

        hb6.getChildren().addAll(six,all_btn[38],all_btn[39],all_btn[40],all_btn[41],all_btn[42],all_btn[43],all_btn[44],all_btn[45],all_btn[46],all_btn[47]);
        hb6.setSpacing(5);
        hb6.setPadding(new Insets(5,45,5,20));

        hb7.getChildren().addAll(seven,all_btn[48],all_btn[49],all_btn[50],all_btn[51],all_btn[52],all_btn[53],all_btn[54],all_btn[55],all_btn[56],all_btn[57]);
        hb7.setSpacing(5);
        hb7.setPadding(new Insets(5,45,5,20));

        hb8.getChildren().addAll(eight,all_btn[58],all_btn[59],all_btn[60],all_btn[61],all_btn[62],all_btn[63],all_btn[64],all_btn[65],all_btn[66],all_btn[67]);
        hb8.setSpacing(5);
        hb8.setPadding(new Insets(5,45,5,20));

        hb9.getChildren().addAll(nine,all_btn[68],all_btn[69],all_btn[70],all_btn[71],all_btn[72],all_btn[73],all_btn[74],all_btn[75],all_btn[76],all_btn[77]);
        hb9.setSpacing(5);
        hb9.setPadding(new Insets(5,45,5,20));

        hb10.getChildren().addAll(ten,f2,all_btn[78],all_btn[79],all_btn[80],all_btn[81],all_btn[82],all_btn[83]);
        hb10.setSpacing(5);
        hb10.setPadding(new Insets(5,45,5,20));

        HBox scn = new HBox();
        scn.getChildren().addAll(f1,screen);
        scn.setSpacing(5);
        scn.setPadding(new Insets(5,10,20,20));

        //grouping left side of design
        VBox vb1 = new VBox();
        vb1.setAlignment(Pos.TOP_CENTER);
        vb1.setMinSize(430,0);
        vb1.getChildren().addAll(scn,hb1,hb2,hb3,hb4,hb5,hb6,hb7,hb8,hb9,hb10);

        //event handling to buttons
        all_btn[0].setOnAction(e->setDisplay(all_btn[0],0));
        all_btn[1].setOnAction(e->setDisplay(all_btn[1],1));
        all_btn[2].setOnAction(e->setDisplay(all_btn[2],2));
        all_btn[3].setOnAction(e->setDisplay(all_btn[3],3));
        all_btn[4].setOnAction(e->setDisplay(all_btn[4],4));
        all_btn[5].setOnAction(e->setDisplay(all_btn[5],5));
        all_btn[6].setOnAction(e->setDisplay(all_btn[6],6));
        all_btn[7].setOnAction(e->setDisplay(all_btn[7],7));
        all_btn[8].setOnAction(e->setDisplay(all_btn[8],8));
        all_btn[9].setOnAction(e->setDisplay(all_btn[9],9));
        all_btn[10].setOnAction(e->setDisplay(all_btn[10],10));
        all_btn[11].setOnAction(e->setDisplay(all_btn[11],11));
        all_btn[12].setOnAction(e->setDisplay(all_btn[12],12));
        all_btn[13].setOnAction(e->setDisplay(all_btn[13],13));
        all_btn[14].setOnAction(e->setDisplay(all_btn[14],14));
        all_btn[15].setOnAction(e->setDisplay(all_btn[15],15));
        all_btn[16].setOnAction(e->setDisplay(all_btn[16],16));
        all_btn[17].setOnAction(e->setDisplay(all_btn[17],17));
        all_btn[18].setOnAction(e->setDisplay(all_btn[18],18));
        all_btn[19].setOnAction(e->setDisplay(all_btn[19],19));
        all_btn[20].setOnAction(e->setDisplay(all_btn[20],20));
        all_btn[21].setOnAction(e->setDisplay(all_btn[21],21));
        all_btn[22].setOnAction(e->setDisplay(all_btn[22],22));
        all_btn[23].setOnAction(e->setDisplay(all_btn[23],23));
        all_btn[24].setOnAction(e->setDisplay(all_btn[24],24));
        all_btn[25].setOnAction(e->setDisplay(all_btn[25],25));
        all_btn[26].setOnAction(e->setDisplay(all_btn[26],26));
        all_btn[27].setOnAction(e->setDisplay(all_btn[27],27));
        all_btn[28].setOnAction(e->setDisplay(all_btn[28],28));
        all_btn[29].setOnAction(e->setDisplay(all_btn[29],29));
        all_btn[30].setOnAction(e->setDisplay(all_btn[30],30));
        all_btn[31].setOnAction(e->setDisplay(all_btn[31],31));
        all_btn[32].setOnAction(e->setDisplay(all_btn[32],32));
        all_btn[33].setOnAction(e->setDisplay(all_btn[33],33));
        all_btn[34].setOnAction(e->setDisplay(all_btn[34],34));
        all_btn[35].setOnAction(e->setDisplay(all_btn[35],35));
        all_btn[36].setOnAction(e->setDisplay(all_btn[36],36));
        all_btn[37].setOnAction(e->setDisplay(all_btn[37],37));
        all_btn[38].setOnAction(e->setDisplay(all_btn[38],38));
        all_btn[39].setOnAction(e->setDisplay(all_btn[39],39));
        all_btn[40].setOnAction(e->setDisplay(all_btn[40],40));
        all_btn[41].setOnAction(e->setDisplay(all_btn[41],41));
        all_btn[42].setOnAction(e->setDisplay(all_btn[42],42));
        all_btn[43].setOnAction(e->setDisplay(all_btn[43],43));
        all_btn[44].setOnAction(e->setDisplay(all_btn[44],44));
        all_btn[45].setOnAction(e->setDisplay(all_btn[45],45));
        all_btn[46].setOnAction(e->setDisplay(all_btn[46],46));
        all_btn[47].setOnAction(e->setDisplay(all_btn[47],47));
        all_btn[48].setOnAction(e->setDisplay(all_btn[48],48));
        all_btn[49].setOnAction(e->setDisplay(all_btn[49],49));
        all_btn[50].setOnAction(e->setDisplay(all_btn[50],50));
        all_btn[51].setOnAction(e->setDisplay(all_btn[51],51));
        all_btn[52].setOnAction(e->setDisplay(all_btn[52],52));
        all_btn[53].setOnAction(e->setDisplay(all_btn[53],53));
        all_btn[54].setOnAction(e->setDisplay(all_btn[54],54));
        all_btn[55].setOnAction(e->setDisplay(all_btn[55],55));
        all_btn[56].setOnAction(e->setDisplay(all_btn[56],56));
        all_btn[57].setOnAction(e->setDisplay(all_btn[57],57));
        all_btn[58].setOnAction(e->setDisplay(all_btn[58],58));
        all_btn[59].setOnAction(e->setDisplay(all_btn[59],59));
        all_btn[60].setOnAction(e->setDisplay(all_btn[60],60));
        all_btn[61].setOnAction(e->setDisplay(all_btn[61],61));
        all_btn[62].setOnAction(e->setDisplay(all_btn[62],62));
        all_btn[63].setOnAction(e->setDisplay(all_btn[63],63));
        all_btn[64].setOnAction(e->setDisplay(all_btn[64],64));
        all_btn[65].setOnAction(e->setDisplay(all_btn[65],65));
        all_btn[66].setOnAction(e->setDisplay(all_btn[66],66));
        all_btn[67].setOnAction(e->setDisplay(all_btn[67],67));
        all_btn[68].setOnAction(e->setDisplay(all_btn[68],68));
        all_btn[69].setOnAction(e->setDisplay(all_btn[69],69));
        all_btn[70].setOnAction(e->setDisplay(all_btn[70],70));
        all_btn[71].setOnAction(e->setDisplay(all_btn[71],71));
        all_btn[72].setOnAction(e->setDisplay(all_btn[72],72));
        all_btn[73].setOnAction(e->setDisplay(all_btn[73],73));
        all_btn[74].setOnAction(e->setDisplay(all_btn[74],74));
        all_btn[75].setOnAction(e->setDisplay(all_btn[75],75));
        all_btn[76].setOnAction(e->setDisplay(all_btn[76],76));
        all_btn[77].setOnAction(e->setDisplay(all_btn[77],77));
        all_btn[78].setOnAction(e->setDisplay(all_btn[78],78));
        all_btn[79].setOnAction(e->setDisplay(all_btn[79],79));
        all_btn[80].setOnAction(e->setDisplay(all_btn[80],80));
        all_btn[81].setOnAction(e->setDisplay(all_btn[81],81));
        all_btn[82].setOnAction(e->setDisplay(all_btn[82],82));
        all_btn[83].setOnAction(e->setDisplay(all_btn[83],83));

        movie = new Label("Movie");
        movie.setFont(new Font("Verdana",14));
        movie.setTextFill(Color.rgb(255,165,0));
        movie.setPrefSize(70,25);

        time = new Label("Time");
        time.setFont(new Font("Verdana",14));
        time.setTextFill(Color.rgb(255,165,0));
        time.setPrefSize(70,25);

        tickets = new Label("Tickets");
        tickets.setFont(new Font("Verdana",14));
        tickets.setTextFill(Color.rgb(255,165,0));
        tickets.setPrefSize(70,25);

        total = new Label("Total");
        total.setFont(new Font("Verdana",14));
        total.setTextFill(Color.rgb(255,165,0));
        total.setPrefSize(70,25);

        seats = new Label("Seats");
        seats.setFont(new Font("Verdana",14));
        seats.setTextFill(Color.rgb(255,165,0));
        seats.setPrefSize(70,25);

        movie_ans = new Label(": Deep Blade");
        movie_ans.setFont(new Font("Verdana",14));
        movie_ans.setPrefSize(200,25);

        time_ans = new Label(": August 12, 10:30");
        time_ans.setFont(new Font("Verdana",14));
        time_ans.setPrefSize(500,25);

        tickets_ans = new Label(": 0");
        tickets_ans.setFont(new Font("Verdana",14));
        tickets_ans.setPrefSize(200,25);

        total_ans = new Label(": $ 0");
        total_ans.setFont(new Font("Verdana",14));
        total_ans.setPrefSize(200,25);

        seats_ans = new Label(": ");
        seats_ans.setFont(new Font("Verdana",14));
        seats_ans.setPrefSize(2200,25);

        //customize book now button
        book = new Button("Book now");
        book.setStyle("-fx-background-color: #FFA500");
        book.setTextFill(Color.rgb(255,255,255));
        book.setFont(new Font("Verdana",14));
        book.setPadding(new Insets(8,8,8,8));
        //handle event in book now button
        book.setOnAction(e->{
            for(int i=0;i<84;i++){
                if(selected_btn[i]!=null){
                    selected_btn[i].setStyle("-fx-background-color:#EE4B2B");
                    //after sold a seat, remove event handle part corresponding button
                    selected_btn[i].setOnAction(f->{});
                }
            }
            tickets_ans.setText(": 0");
            total_ans.setText(": $ 0");
            seats_ans.setText(": ");
            seats_val = ": ";
            count += ticket;
            //when after all seats were booked, disable book now button
            if(count==all_btn.length){
                book.setDisable(true);
            }
            ticket = 0;
            amount = 0;
            Button[] temp_btn = new Button[84];
            selected_btn = temp_btn;
        });

        b_available = new Button();
        b_available.setStyle("-fx-background-color:#B2BEB5");
        b_available.setPrefSize(30,35);

        b_sold = new Button();
        b_sold.setStyle("-fx-background-color:#EE4B2B");
        b_sold.setPrefSize(30,35);

        b_selected = new Button();
        b_selected.setStyle("-fx-background-color:#32CD32");
        b_selected.setPrefSize(30,35);

        available = new Label("Available");
        available.setFont(new Font("Verdana",14));
        available.setAlignment(Pos.CENTER_LEFT);
        available.setPadding(new Insets(7,50,5,3));

        sold = new Label("Sold");
        sold.setFont(new Font("Verdana",14));
        sold.setAlignment(Pos.CENTER_LEFT);
        sold.setPadding(new Insets(7,50,5,3));

        selected = new Label("Selected");
        selected.setFont(new Font("Verdana",14));
        selected.setAlignment(Pos.CENTER_LEFT);
        selected.setPadding(new Insets(7,50,5,3));

        //grouping right hand side in showing screen
        VBox temp1 = new VBox();
        temp1.getChildren().addAll(movie,time,tickets,total,seats);
        temp1.setMinSize(70,0);

        VBox temp2 = new VBox();
        temp2.getChildren().addAll(movie_ans,time_ans,tickets_ans,total_ans,seats_ans);
        temp2.setMinSize(70,0);

        HBox h1 = new HBox();
        h1.getChildren().addAll(temp1,temp2);
        h1.setPadding(new Insets(5,5,5,5));
        h1.setSpacing(10);

        HBox h6 = new HBox();
        h6.getChildren().add(book);
        h6.setPadding(new Insets(20,5,20,5));
        h6.setSpacing(10);

        HBox h7 = new HBox();
        h7.getChildren().addAll(b_available,available);
        h7.setPadding(new Insets(5,5,5,5));
        h7.setSpacing(10);

        HBox h8 = new HBox();
        h8.getChildren().addAll(b_sold,sold);
        h8.setPadding(new Insets(5,5,5,5));
        h8.setSpacing(10);

        HBox h9 = new HBox();
        h9.getChildren().addAll(b_selected,selected);
        h9.setPadding(new Insets(5,5,5,5));
        h9.setSpacing(10);

        //separate left and right side using separator
        Separator s = new Separator();
        s.setOrientation(Orientation.VERTICAL);
        s.setMinSize(20,0);

        VBox vb2 = new VBox();
        vb2.getChildren().addAll(h1,h6,h7,h8,h9);
        vb2.setMaxSize(2500,2500);

        HBox mainHB = new HBox();
        mainHB.getChildren().addAll(vb1,s,vb2);

        VBox mainVB = new VBox();
        mainVB.setAlignment(Pos.TOP_CENTER);
        mainVB.getChildren().addAll(title,mainHB);

        //set scene and show
    }
}

