package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_field;

    @FXML
    private Button seven_button;

    @FXML
    private Button pm_button;

    @FXML
    private Button module_button;

    @FXML
    private Button divide_button;

    @FXML
    private Button eigth_button;

    @FXML
    private Button clear_button;

    @FXML
    private Button nine_button;

    @FXML
    private Button mult_button;

    @FXML
    private Button four_button;

    @FXML
    private Button five_button;

    @FXML
    private Button six_button;

    @FXML
    private Button minus_button;

    @FXML
    private Button one_button;

    @FXML
    private Button null_button;

    @FXML
    private Button two_button;

    @FXML
    private Button three_button;

    @FXML
    private Button plus_button;

    @FXML
    private Button double_button;

    @FXML
    private Button equals_button;

    private String str_num = "";
    private float first_num = 0;
    private char operation;
    private final static int[] arrayNumbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};


    @FXML
    void initialize() {
        initButtonNumber();

        plus_button.setOnAction(actionEvent -> {
            mathAction('+');
        });

        minus_button.setOnAction(actionEvent -> {
            mathAction('-');
        });

        divide_button.setOnAction(actionEvent -> {
            mathAction('/');
        });

        mult_button.setOnAction(actionEvent -> {
            mathAction('*');
        });

        equals_button.setOnAction(actionEvent -> {
            if (this.operation == '+' || this.operation == '-'
                    || this.operation == '/' || this.operation == '*') {
                equalsMethod();
            }
        });


        double_button.setOnAction(actionEvent -> {
            this.str_num += ".";
            if (this.str_num.contains(".")) {
                label_field.setText(str_num);

            }
        });

        module_button.setOnAction(actionEvent -> {
            if (this.str_num != "") {
                float num = Float.parseFloat(this.str_num) * 0.1f;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        pm_button.setOnAction(actionEvent -> {
            if (this.str_num != "") {
                float num = Float.parseFloat(this.str_num) * -1;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });

        clear_button.setOnAction(actionEvent -> {
            label_field.setText("0");
            this.str_num = "";
            this.first_num = 0;
            this.operation = 'A';
        });

    }

    private void mathAction(char operation) {
        if (this.operation != '+' && this.operation != '-'
                && this.operation != '/' && this.operation != '*') {
            this.first_num = Float.parseFloat(this.str_num);
            label_field.setText(String.valueOf(operation));// выводим знак операции
            this.str_num = "";
            this.operation = operation;
        }

    }

    private void addNumberFromLabel(int Number) {
        this.str_num += Integer.toString(Number);
        label_field.setText(str_num);// setText - установка текста на поле
    }

    private void equalsMethod() {
        float res = 0;
        switch (this.operation) {
            case '+':
                res = this.first_num + Float.parseFloat(this.str_num);
                break;

            case '-':
                res = this.first_num - Float.parseFloat(this.str_num);
                break;

            case '*':
                res = this.first_num * Float.parseFloat(this.str_num);
                break;

            case '/':
                if (Integer.parseInt(this.str_num) != 0) {
                    res = this.first_num / Float.parseFloat(this.str_num);
                    break;
                } else {
                    res = 0;
                }

        }

        label_field.setText(Float.toString(res));
        this.str_num = "";
        this.operation = 'A';
        this.first_num = 0;
    }

    public void initButtonNumber() {
        Button[] listButtons = new Button[]{null_button, one_button, two_button, three_button,
                four_button, five_button, six_button, seven_button, eigth_button, nine_button,};
        for (int i : arrayNumbers) {
            listButtons[i].setOnAction(actionEvent -> {
                addNumberFromLabel(arrayNumbers[i]);
            });
        }
    }


}
