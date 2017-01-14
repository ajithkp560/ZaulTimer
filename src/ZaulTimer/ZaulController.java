package ZaulTimer;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.*;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ZaulController implements Initializable {
    @FXML
    AnchorPane ParticleFX, MainFX;
    @FXML
    StackPane TimerFX;
    @FXML
    TextFlow ZeitgeistFX, ShowFX, ZaulFX;
    Random random = new Random();
    Circle[] c = new Circle[2000];
    Text t[] = new Text[5];
    Timeline timeline;
    Integer timesec = 15 * 60;
    Text z[] = new Text[3];

    KeyCodeCombination resume, pause, time15, time05, time01, hide;

    Font f = Font.loadFont(getClass().getResource("vermin-vibes.ttf").toExternalForm(), 100);
    Font f2 = Font.loadFont(getClass().getResource("vermin-vibes.ttf").toExternalForm(), 125);

    @FXML
    public void KeyPressed(KeyEvent event) {
        if(resume.match(event)){
            //timeline.play();
            timeline.stop();
            timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            startTimer();
            timeline.playFromStart();
        }
        if(pause.match(event)){
            timeline.pause();
        }
        if(time05.match(event)){
            timesec = 5 * 60;

            timeline.stop();

            String ss = "Time Left: 05:00";

            try {
                ShowFX.getChildren().remove(0, ss.length());
            }catch (Exception e){
            }

            Text tt[] = new Text[ss.length()];
            for (int i = 0; i < ss.length(); i++) {
                tt[i] = new Text(""+ss.charAt(i));
                tt[i].setFont(f);
                if(i%2==0){
                    tt[i].setFill(Color.rgb(255, 255, 255));
                }
                else{
                    tt[i].setFill(Color.rgb(255, 0, 0));
                }
                ShowFX.getChildren().add(tt[i]);
            }
        }

        if(time01.match(event)){
            timesec = 1*60;

            timeline.stop();

            String ss = "Time Left: 01:00";

            try {
                ShowFX.getChildren().remove(0, ss.length());
            }catch (Exception e){
            }

            Text tt[] = new Text[ss.length()];
            for (int i = 0; i < ss.length(); i++) {
                tt[i] = new Text(""+ss.charAt(i));
                tt[i].setFont(f);
                if(i%2==0){
                    tt[i].setFill(Color.rgb(255, 255, 255));
                }
                else{
                    tt[i].setFill(Color.rgb(255, 0, 0));
                }
                ShowFX.getChildren().add(tt[i]);
            }
        }
        if(time15.match(event)){
            timesec = 10*60;

            timeline.stop();

            String ss = "Time Left: 10:00";

            try {
                ShowFX.getChildren().remove(0, ss.length());
            }catch (Exception e){
            }
            Text tt[] = new Text[ss.length()];
            for (int i = 0; i < ss.length(); i++) {
                tt[i] = new Text(""+ss.charAt(i));
                tt[i].setFont(f);
                if(i%2==0){
                    tt[i].setFill(Color.rgb(255, 255, 255));
                }
                else{
                    tt[i].setFill(Color.rgb(255, 0, 0));
                }
                ShowFX.getChildren().add(tt[i]);
            }
        }
        if(hide.match(event)){
            if(ShowFX.isVisible())
                ShowFX.setVisible(false);
            else
                ShowFX.setVisible(true);
        }
    }

    @FXML
    public void KeyRel(KeyEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        resume = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);
        pause = new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN);
        time15 = new KeyCodeCombination(KeyCode.NUMPAD1, KeyCombination.CONTROL_DOWN);
        time05 = new KeyCodeCombination(KeyCode.NUMPAD5, KeyCombination.CONTROL_DOWN);
        time01 = new KeyCodeCombination(KeyCode.NUMPAD0, KeyCombination.CONTROL_DOWN);
        hide = new KeyCodeCombination(KeyCode.H, KeyCombination.CONTROL_DOWN);


        setBackground();

        z[0] = new Text("Z");
        z[1] = new Text("A");
        z[2] = new Text("UL");

        t[0] = new Text("ze");
        t[1] = new Text("IT");
        t[2] = new Text("geist 2");
        t[3] = new Text("K");
        t[4] = new Text("17");

        t[0].setFill(Color.rgb(255, 255, 255));
        z[0].setFill(Color.rgb(255, 255, 255));
        t[1].setFill(Color.rgb(255, 000, 000));
        z[1].setFill(Color.rgb(255, 000, 000));
        t[2].setFill(Color.rgb(255, 255, 255));
        z[2].setFill(Color.rgb(255, 255, 255));
        t[3].setFill(Color.rgb(255, 000, 000));
        t[4].setFill(Color.rgb(255, 255, 255));

        //Font f = new Font("vermin vibes", 100);

        for (int i=0;i<5;i++)
            t[i].setFont(f);
        for(int i=0;i<3;i++)
            z[i].setFont(f2);

        ZeitgeistFX.getChildren().addAll(t[0], t[1], t[2], t[3], t[4]);
        ZaulFX.getChildren().addAll(z[0], z[1], z[2]);

        FadeTransition ft = new FadeTransition(Duration.millis(1000), ZeitgeistFX);
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(Animation.INDEFINITE);
        ft.playFromStart();

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        //ParticleFX.getChildren().add(c);
        //startTimer();

        ScaleTransition st = new ScaleTransition(Duration.millis(750), ShowFX);
        st.setByX(0.05);
        st.setByY(0.05);
        st.setAutoReverse(true);
        st.setCycleCount(Animation.INDEFINITE);
        st.play();
    }

    public void setBackground(){
        String imageName = "ZaulIcons_4.jpg";
        ImageView background = new ImageView(new Image(getClass().getResource("Zaul/"+imageName).toString()));
        ParticleFX.getChildren().add(background);

        for (int i=0;i<2000;i++){
            c[i] = new Circle(1, 1, 1);
            c[i].setRadius(random.nextDouble()*3);
            Color color = Color.rgb(255, 255, 255, random.nextDouble());
            c[i].setFill(color);
            ParticleFX.getChildren().add(c[i]);
            Raining(c[i]);
        }
    }

    public void Raining(Circle c){
        //c.setCenterX(random.nextInt((int)ParticleFX.getWidth()));
        c.setCenterX(random.nextInt(1366));
        int time = 5+random.nextInt(50);
        Animation walk = TranslateTransitionBuilder.create()
                .node(c)
                .fromY(-100)
                .toY(886)
                .toX(random.nextDouble()*c.getCenterX())
                .duration(Duration.seconds(time))
                .onFinished(new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent t) {
                        Raining(c);
                    }
                }).build();
        walk.play();
    }

    public void startTimer(){
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                String sec = "" + (timesec % 60);
                                if ((timesec % 60) < 10)
                                    sec = "0" + (timesec % 60);
                                String min = "" + (timesec / 60);
                                if ((timesec / 60) < 10)
                                    min = "0" + (timesec / 60);
                                timesec--;
                                //Text tt = new Text("Time Left: " + min + ":" + sec);
                                //tt.setFill(Color.WHITESMOKE);
                                //tt.setFont(f);

                                String ss = "Time Left: " + min + ":" + sec;

                                try {
                                    ShowFX.getChildren().remove(0, ss.length());
                                }catch (Exception e){

                                }

                                Text tt[] = new Text[ss.length()];

                                for (int i = 0; i < ss.length(); i++) {
                                    tt[i] = new Text(""+ss.charAt(i));
                                    tt[i].setFont(f);
                                    if(i%2==0){
                                        tt[i].setFill(Color.rgb(255, 255, 255));
                                    }
                                    else{
                                        tt[i].setFill(Color.rgb(255, 0, 0));
                                    }
                                    ShowFX.getChildren().add(tt[i]);
                                }

                                //ShowFX.getChildren().addAll(tt);
                                if (timesec <= 0) {
                                    timeline.stop();
                                    //finish();
                                }
                            }
                        }));
    }

}
