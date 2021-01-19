package pro.gr.ams.stimsc;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AppActivity extends AppCompatActivity {

    //Database
    String u1Id = "1", u1FName = "John Rovic", u1Lname = "Lalusin", u1State = "freshmen", u1Password = "123456789", u1changed = "true";
    String u2Id = "2", u2FName = "Mae Paulene", u2Lname = "Ilagan", u2State = "freshmen", u2Password = "12345678", u2changed = "false";
    String u3Id = "3", u3FName = "Jerome", u3Lname = "Lalunio", u3State = "transferee", u3Password = "12345678", u3changed = "false";
    String u4Id = "4", u4FName = "Kaye Angel", u4Lname = "Lanto", u4State = "freshmen", u4Password = "12345678", u4changed = "false";
    String u5Id = "5", u5FName = "Gabrielle", u5Lname = "Manimtim", u5State = "transferee", u5Password = "12345678", u5changed = "false";

    boolean u1Form138 = false, u1Form137 = false, u1PSA = false, u1HonDis = false, u1Transcript = false;
    String u1Accounting = "Balance: P4,000", u1Library = "All Books Returned";
    boolean u1IndInv = false, u1CareerPlan = false, u1Consent = false;
    boolean u1Discipline = false, u1ComLab = false, u1Lab = false, u1Alumni = false;

    boolean u2Form138 = false, u2Form137 = false, u2PSA = false, u2HonDis = false, u2Transcript = false;
    String u2Accounting = "Balance: P5,000", u2Library = "All Books Returned";
    boolean u2IndInv = false, u2CareerPlan = false, u2Consent = false;
    boolean u2Discipline = false, u2ComLab = false, u2Lab = false, u2Alumni = false;

    boolean u3Form138 = false, u3Form137 = false, u3PSA = false, u3HonDis = false, u3Transcript = false;
    String u3Accounting = "Balance: P9,000", u3Library = "All Books Returned";
    boolean u3IndInv = false, u3CareerPlan = false, u3Consent = false;
    boolean u3Discipline = false, u3ComLab = false, u3Lab = false, u3Alumni = false;

    boolean u4Form138 = false, u4Form137 = false, u4PSA = false, u4HonDis = false, u4Transcript = false;
    String u4Accounting = "Balance: P12,000", u4Library = "All Books Returned";
    boolean u4IndInv = false, u4CareerPlan = false, u4Consent = false;
    boolean u4Discipline = false, u4ComLab = false, u4Lab = false, u4Alumni = false;

    boolean u5Form138 = true, u5Form137 = true, u5PSA = true, u5HonDis = true, u5Transcript = true;
    String u5Accounting = "No Balance", u5Library = "All Books Returned";
    boolean u5IndInv = true, u5CareerPlan = true, u5Consent = true;
    boolean u5Discipline = true, u5ComLab = true, u5Lab = true, u5Alumni = true;

    String personelPass = "0312";
    //Database

    private String activeAct = "";
    private int backCount = 0;
    private EditText logIn_StudentIDDTTXT;
    private EditText logIn_PasswordDTTXT;
    private Button logIn_logInBTTN;
    private int activeUser = -1;
    private Button mainUser_LogOutBTTN;
    private TextView mainUserLastNameTXTVW;
    private TextView mainUserFirstNameTXTVW;
    private EditText dialogPass_newPassDTTXT;
    private TextView dialogPass_StatusTXTVW;
    private Button logIn_logInPersonelBTTN;
    private EditText dialogPersonelPass_passDTTXT;
    private LinearLayout mainUser_RegistrarLNRLYT;
    private LinearLayout mainUser_libraryLNRLYT;
    private LinearLayout mainUser_AccountingLNRLYT;
    private LinearLayout mainUser_GuidanceLNRLYT;
    private LinearLayout mainUser_MoreLNRLYT;
    private Button schoolPersonel_LogOutBTTN;
    private TextView schoolPersonel_U1LNameTXTVW;
    private TextView schoolPersonel_U2LNameTXTVW;
    private TextView schoolPersonel_U3LNameTXTVW;
    private TextView schoolPersonel_U4LNameTXTVW;
    private TextView schoolPersonel_U5LNameTXTVW;
    private TextView schoolPersonel_U1FNameTXTVW;
    private TextView schoolPersonel_U2FNameTXTVW;
    private TextView schoolPersonel_U3FNameTXTVW;
    private TextView schoolPersonel_U4FNameTXTVW;
    private TextView schoolPersonel_U5FNameTXTVW;
    private LinearLayout schoolPersonel_u1LNRLYT;
    private LinearLayout schoolPersonel_u2LNRLYT;
    private LinearLayout schoolPersonel_u3LNRLYT;
    private LinearLayout schoolPersonel_u4LNRLYT;
    private LinearLayout schoolPersonel_u5LNRLYT;
    private Button schoolPersonel_SearchBTTN;
    private EditText schoolPersonel_SearchDTTXT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        try {
            logInActivity();


            //activeUser = 1;
            //checkPassChanged();
            //popUpFreshMen();
            //popUpLibrary();

            //popUpAccounting();

            //personelActivity();

        }
        catch (Exception ex) {
            Toast.makeText(this, ""+ex, Toast.LENGTH_SHORT).show();
        }
    }

    private void popUpMore() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.dialog_status, null);
        dialogPass_StatusTXTVW = (TextView)dialogView.findViewById(R.id.dialogPass_StatusTXTVW);
        builder.setView(dialogView)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.create();
        builder.show();

        if (activeUser == 1) {
            dialogPass_StatusTXTVW.setText("");
            if (u1Discipline == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited discipline office!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit discipline office!");
            }
            if (u1ComLab == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Computer Laboratory!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Computer Laboratory!");
            }
            if (u1Lab == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Laboratory Custodian!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Laboratory Custodian!");
            }
            if (u1Alumni == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Alumni and Placement Office!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Alumni and Placement Office!");
            }
        }
        else if (activeUser == 2) {
            dialogPass_StatusTXTVW.setText("");
            if (u2Discipline == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited discipline office!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit discipline office!");
            }
            if (u2ComLab == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Computer Laboratory!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Computer Laboratory!");
            }
            if (u2Lab == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Laboratory Custodian!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Laboratory Custodian!");
            }
            if (u2Alumni == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Alumni and Placement Office!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Alumni and Placement Office!");
            }
        }
        else if (activeUser == 3) {
            dialogPass_StatusTXTVW.setText("");
            if (u3Discipline == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited discipline office!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit discipline office!");
            }
            if (u3ComLab == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Computer Laboratory!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Computer Laboratory!");
            }
            if (u3Lab == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Laboratory Custodian!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Laboratory Custodian!");
            }
            if (u3Alumni == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Alumni and Placement Office!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Alumni and Placement Office!");
            }
        }
        else if (activeUser == 4) {
            dialogPass_StatusTXTVW.setText("");
            if (u4Discipline == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited discipline office!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit discipline office!");
            }
            if (u4ComLab == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Computer Laboratory!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Computer Laboratory!");
            }
            if (u4Lab == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Laboratory Custodian!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Laboratory Custodian!");
            }
            if (u4Alumni == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Alumni and Placement Office!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Alumni and Placement Office!");
            }
        }
        else if (activeUser == 5) {
            dialogPass_StatusTXTVW.setText("");
            if (u5Discipline == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited discipline office!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit discipline office!");
            }
            if (u5ComLab == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Computer Laboratory!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Computer Laboratory!");
            }
            if (u5Lab == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Laboratory Custodian!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Laboratory Custodian!");
            }
            if (u5Alumni == true) {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Already visited Alumni and Placement Office!");
            }
            else {
                dialogPass_StatusTXTVW.setText(dialogPass_StatusTXTVW.getText().toString() +"\n" +"Need to visit Alumni and Placement Office!");
            }
        }
    }


    private void popUpGuidance() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.dialog_status, null);
        dialogPass_StatusTXTVW = (TextView)dialogView.findViewById(R.id.dialogPass_StatusTXTVW);
        builder.setView(dialogView)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.create();
        builder.show();

        if (activeUser == 1) {
            if (u1Discipline == true) {
                dialogPass_StatusTXTVW.setText("Already visited guidance!");
            }
            else {
                dialogPass_StatusTXTVW.setText("Need to visit guidance!");
            }
        }
        if (activeUser == 2) {
            if (u2Discipline == true) {
                dialogPass_StatusTXTVW.setText("Already visited guidance!");
            }
            else {
                dialogPass_StatusTXTVW.setText("Need to visit guidance!");
            }
        }
        if (activeUser == 3) {
            if (u3Discipline == true) {
                dialogPass_StatusTXTVW.setText("Already visited guidance!");
            }
            else {
                dialogPass_StatusTXTVW.setText("Need to visit guidance!");
            }
        }
        if (activeUser == 4) {
            if (u4Discipline == true) {
                dialogPass_StatusTXTVW.setText("Already visited guidance!");
            }
            else {
                dialogPass_StatusTXTVW.setText("Need to visit guidance!");
            }
        }
        if (activeUser == 5) {
            if (u5Discipline == true) {
                dialogPass_StatusTXTVW.setText("Already visited guidance!");
            }
            else {
                dialogPass_StatusTXTVW.setText("Need to visit guidance!");
            }
        }
    }

    private void popUpAccounting() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.dialog_status, null);
        dialogPass_StatusTXTVW = (TextView)dialogView.findViewById(R.id.dialogPass_StatusTXTVW);
        builder.setView(dialogView)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.create();
        builder.show();

        if (activeUser == 1) {
            dialogPass_StatusTXTVW.setText(u1Accounting);
        }
        else if (activeUser == 2) {
            dialogPass_StatusTXTVW.setText(u2Accounting);
        }
        else if (activeUser == 3) {
            dialogPass_StatusTXTVW.setText(u3Accounting);
        }
        else if (activeUser == 4) {
            dialogPass_StatusTXTVW.setText(u4Accounting);
        }
        else if (activeUser == 5) {
            dialogPass_StatusTXTVW.setText(u5Accounting);
        }
    }

    private void popUpLibrary() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.dialog_status, null);
        dialogPass_StatusTXTVW = (TextView)dialogView.findViewById(R.id.dialogPass_StatusTXTVW);
        builder.setView(dialogView)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.create();
        builder.show();

        if (activeUser == 1) {
            dialogPass_StatusTXTVW.setText(u1Library);
        }
        else if (activeUser == 2) {
            dialogPass_StatusTXTVW.setText(u2Library);
        }
        else if (activeUser == 3) {
            dialogPass_StatusTXTVW.setText(u3Library);
        }
        else if (activeUser == 4) {
            dialogPass_StatusTXTVW.setText(u4Library);
        }
        else if (activeUser == 5) {
            dialogPass_StatusTXTVW.setText(u5Library);
        }
    }

    private void popUpFreshMen() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.dialog_status, null);
        dialogPass_StatusTXTVW = (TextView)dialogView.findViewById(R.id.dialogPass_StatusTXTVW);
        builder.setView(dialogView)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.create();
        builder.show();

        if (activeUser == 1) {
            if (u1State.equals("freshmen")) {
                String userData  = "";
                if (u1Form138 == false) {
                    userData = userData + "Form 138: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Form 138: Submitted\n";
                }


                if (u1Form137 == false) {
                    userData = userData + "Form 137: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Form 137: Submitted\n";
                }

                if (u1PSA == false) {
                    userData = userData + "PSA: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "PSA: Submitted\n";
                }
                dialogPass_StatusTXTVW.setText(userData);
            }
            else if (u1State.equals("transferee")) {
                String userData  = "";
                if (u1HonDis == false) {
                    userData = userData + "Honorable Dismissal: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Honorable Dismissal: Submitted\n";
                }


                if (u1Transcript == false) {
                    userData = userData + "Transcript Of Records: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Transcript Of Records: Submitted\n";
                }

                if (u1PSA == false) {
                    userData = userData + "PSA: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "PSA: Submitted\n";
                }
                dialogPass_StatusTXTVW.setText(userData);
            }
        }

        else if (activeUser == 2) {
            if (u2State.equals("freshmen")) {
                String userData  = "";
                if (u2Form138 == false) {
                    userData = userData + "Form 138: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Form 138: Submitted\n";
                }


                if (u2Form137 == false) {
                    userData = userData + "Form 137: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Form 137: Submitted\n";
                }

                if (u2PSA == false) {
                    userData = userData + "PSA: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "PSA: Submitted\n";
                }
                dialogPass_StatusTXTVW.setText(userData);
            }
            else if (u2State.equals("transferee")) {
                String userData  = "";
                if (u2HonDis == false) {
                    userData = userData + "Honorable Dismissal: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Honorable Dismissal: Submitted\n";
                }


                if (u2Transcript == false) {
                    userData = userData + "Transcript Of Records: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Transcript Of Records: Submitted\n";
                }

                if (u2PSA == false) {
                    userData = userData + "PSA: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "PSA: Submitted\n";
                }
                dialogPass_StatusTXTVW.setText(userData);
            }
        }
        else if (activeUser == 3) {
            if (u3State.equals("freshmen")) {
                String userData  = "";
                if (u3Form138 == false) {
                    userData = userData + "Form 138: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Form 138: Submitted\n";
                }


                if (u3Form137 == false) {
                    userData = userData + "Form 137: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Form 137: Submitted\n";
                }

                if (u3PSA == false) {
                    userData = userData + "PSA: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "PSA: Submitted\n";
                }
                dialogPass_StatusTXTVW.setText(userData);
            }
            else if (u3State.equals("transferee")) {
                String userData  = "";
                if (u3HonDis == false) {
                    userData = userData + "Honorable Dismissal: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Honorable Dismissal: Submitted\n";
                }


                if (u3Transcript == false) {
                    userData = userData + "Transcript Of Records: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Transcript Of Records: Submitted\n";
                }

                if (u3PSA == false) {
                    userData = userData + "PSA: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "PSA: Submitted\n";
                }
                dialogPass_StatusTXTVW.setText(userData);
            }
        }
        else if (activeUser == 4) {
            if (u4State.equals("freshmen")) {
                String userData  = "";
                if (u4Form138 == false) {
                    userData = userData + "Form 138: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Form 138: Submitted\n";
                }


                if (u4Form137 == false) {
                    userData = userData + "Form 137: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Form 137: Submitted\n";
                }

                if (u4PSA == false) {
                    userData = userData + "PSA: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "PSA: Submitted\n";
                }
                dialogPass_StatusTXTVW.setText(userData);
            }
            else if (u4State.equals("transferee")) {
                String userData  = "";
                if (u4HonDis == false) {
                    userData = userData + "Honorable Dismissal: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Honorable Dismissal: Submitted\n";
                }


                if (u4Transcript == false) {
                    userData = userData + "Transcript Of Records: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Transcript Of Records: Submitted\n";
                }

                if (u4PSA == false) {
                    userData = userData + "PSA: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "PSA: Submitted\n";
                }
                dialogPass_StatusTXTVW.setText(userData);
            }
        }
        else if (activeUser == 5) {
            if (u5State.equals("freshmen")) {
                String userData  = "";
                if (u5Form138 == false) {
                    userData = userData + "Form 138: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Form 138: Submitted\n";
                }


                if (u5Form137 == false) {
                    userData = userData + "Form 137: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Form 137: Submitted\n";
                }

                if (u5PSA == false) {
                    userData = userData + "PSA: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "PSA: Submitted\n";
                }
                dialogPass_StatusTXTVW.setText(userData);
            }
            else if (u5State.equals("transferee")) {
                String userData  = "";
                if (u5HonDis == false) {
                    userData = userData + "Honorable Dismissal: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Honorable Dismissal: Submitted\n";
                }


                if (u5Transcript == false) {
                    userData = userData + "Transcript Of Records: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "Transcript Of Records: Submitted\n";
                }

                if (u5PSA == false) {
                    userData = userData + "PSA: Not Yet Submitted\n";
                }
                else {
                    userData = userData + "PSA: Submitted\n";
                }
                dialogPass_StatusTXTVW.setText(userData);
            }
        }
    }

    private void logInActivity() {
        activeAct = "login";
        setContentView(R.layout.layout_login);
        backCount = 0;
        logIn_StudentIDDTTXT = (EditText)findViewById(R.id.logIn_StudentIDDTTXT);
        logIn_PasswordDTTXT = (EditText)findViewById(R.id.logIn_PasswordDTTXT);
        logIn_logInBTTN = (Button)findViewById(R.id.logIn_logInBTTN);
        logIn_logInPersonelBTTN = (Button)findViewById(R.id.logIn_logInPersonelBTTN);
        logIn_logInPersonelBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInPersonelDialog();
            }
        });
        logIn_logInBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studID = logIn_StudentIDDTTXT.getText().toString();
                String pass = logIn_PasswordDTTXT.getText().toString();
                if (studID.length() != 0 && pass.length() != 0) {
                    if (studID.equals(u1Id) && pass.equals(u1Password)) {
                        activeUser = 1;
                        checkPassChanged();
                    }
                    else if (studID.equals(u2Id) && pass.equals(u2Password)) {
                        activeUser = 2;;
                        checkPassChanged();
                    }
                    else if (studID.equals(u3Id) && pass.equals(u3Password)) {
                        activeUser = 3;;
                        checkPassChanged();
                    }
                    else if (studID.equals(u4Id) && pass.equals(u4Password)) {
                        activeUser = 4;;
                        checkPassChanged();
                    }
                    else if (studID.equals(u5Id) && pass.equals(u5Password)) {
                        activeUser = 5;;
                        checkPassChanged();
                    }
                    else {
                        Toast.makeText(AppActivity.this, "Log in failed!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(AppActivity.this, "Please complete the required fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void logInPersonelDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.dialog_personel_pass, null);
        builder.setView(dialogView)
                .setPositiveButton("Log In", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialogPersonelPass_passDTTXT = (EditText)dialogView.findViewById(R.id.dialogPersonelPass_passDTTXT);
                        String pass = dialogPersonelPass_passDTTXT.getText().toString();
                        if (pass.equals(personelPass)) {
                            personelActivity();
                        }
                        else if (pass.length() != 0) {
                            Toast.makeText(AppActivity.this, "Log In Failed!", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.create();
        builder.show();
    }

    private void personelActivity() {
        activeAct = "personel";
        setContentView(R.layout.layout_school_personel);
        backCount = 0;
        schoolPersonel_LogOutBTTN = (Button)findViewById(R.id.schoolPersonel_LogOutBTTN);
        schoolPersonel_u1LNRLYT = (LinearLayout)findViewById(R.id.schoolPersonel_u1LNRLYT);
        schoolPersonel_u2LNRLYT = (LinearLayout)findViewById(R.id.schoolPersonel_u2LNRLYT);
        schoolPersonel_u3LNRLYT = (LinearLayout)findViewById(R.id.schoolPersonel_u3LNRLYT);
        schoolPersonel_u4LNRLYT = (LinearLayout)findViewById(R.id.schoolPersonel_u4LNRLYT);
        schoolPersonel_u5LNRLYT = (LinearLayout)findViewById(R.id.schoolPersonel_u5LNRLYT);

        schoolPersonel_u1LNRLYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseUpdate(1);
            }
        });
        schoolPersonel_u2LNRLYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseUpdate(2);
            }
        });
        schoolPersonel_u3LNRLYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseUpdate(3);
            }
        });
        schoolPersonel_u4LNRLYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseUpdate(4);
            }
        });
        schoolPersonel_u5LNRLYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseUpdate(5);
            }
        });

        schoolPersonel_U1LNameTXTVW = (TextView)findViewById(R.id.schoolPersonel_U1LNameTXTVW);
        schoolPersonel_U2LNameTXTVW = (TextView)findViewById(R.id.schoolPersonel_U2LNameTXTVW);
        schoolPersonel_U3LNameTXTVW = (TextView)findViewById(R.id.schoolPersonel_u3LNameTXTVW);
        schoolPersonel_U4LNameTXTVW = (TextView)findViewById(R.id.schoolPersonel_u4LNameTXTVW);
        schoolPersonel_U5LNameTXTVW = (TextView)findViewById(R.id.schoolPersonel_u5LNameTXTVW);

        schoolPersonel_U1FNameTXTVW = (TextView)findViewById(R.id.schoolPersonel_U1FNameTXTVW);
        schoolPersonel_U2FNameTXTVW = (TextView)findViewById(R.id.schoolPersonel_u2FNameTXTVW);
        schoolPersonel_U3FNameTXTVW = (TextView)findViewById(R.id.schoolPersonel_u3FNameTXTVW);
        schoolPersonel_U4FNameTXTVW = (TextView)findViewById(R.id.schoolPersonel_u4FNameTXTVW);
        schoolPersonel_U5FNameTXTVW = (TextView)findViewById(R.id.schoolPersonel_u5FNameTXTVW);

        schoolPersonel_SearchBTTN = (Button)findViewById(R.id.schoolPersonel_SearchBTTN);
        schoolPersonel_SearchDTTXT = (EditText)findViewById(R.id.schoolPersonel_SearchDTTXT);

        schoolPersonel_U1LNameTXTVW.setText(u1Lname);
        schoolPersonel_U2LNameTXTVW.setText(u2Lname);
        schoolPersonel_U3LNameTXTVW.setText(u3Lname);
        schoolPersonel_U4LNameTXTVW.setText(u4Lname);
        schoolPersonel_U5LNameTXTVW.setText(u5Lname);

        schoolPersonel_U1FNameTXTVW.setText(u1FName);
        schoolPersonel_U2FNameTXTVW.setText(u2FName);
        schoolPersonel_U3FNameTXTVW.setText(u3FName);
        schoolPersonel_U4FNameTXTVW.setText(u4FName);
        schoolPersonel_U5FNameTXTVW.setText(u5FName);

        schoolPersonel_LogOutBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInActivity();
            }
        });
        schoolPersonel_SearchBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchData = schoolPersonel_SearchDTTXT.getText().toString();
                if (searchData.equals("#complete")) {
                    schoolPersonel_u1LNRLYT.setVisibility(View.GONE);
                    schoolPersonel_u2LNRLYT.setVisibility(View.GONE);
                    schoolPersonel_u3LNRLYT.setVisibility(View.GONE);
                    schoolPersonel_u4LNRLYT.setVisibility(View.GONE);
                    schoolPersonel_u5LNRLYT.setVisibility(View.GONE);

                    if (u1Form138 == true && u1Form137 == true && u1PSA == true && u1HonDis == true && u1Transcript == true &&
                            u1Accounting.equals("No Balance") && u1Library.equals("All Books Returned") == true &&
                            u1IndInv == true && u1CareerPlan == true && u1Consent == true &&
                            u1Discipline == true && u1ComLab == true  && u1Lab == true && u1Alumni == true) {
                        schoolPersonel_u1LNRLYT.setVisibility(View.VISIBLE);
                    }
                    else if (u2Form138 == true && u2Form137 == true && u2PSA == true && u2HonDis == true && u2Transcript == true &&
                            u2Accounting.equals("No Balance") && u2Library.equals("All Books Returned") == true &&
                            u2IndInv == true && u2CareerPlan == true && u2Consent == true &&
                            u2Discipline == true && u2ComLab == true  && u2Lab == true && u2Alumni == true) {
                        schoolPersonel_u2LNRLYT.setVisibility(View.VISIBLE);
                    }
                    else if (u3Form138 == true && u3Form137 == true && u3PSA == true && u3HonDis == true && u3Transcript == true &&
                            u3Accounting.equals("No Balance") && u3Library.equals("All Books Returned") == true &&
                            u3IndInv == true && u3CareerPlan == true && u3Consent == true &&
                            u3Discipline == true && u3ComLab == true  && u3Lab == true && u3Alumni == true) {
                        schoolPersonel_u3LNRLYT.setVisibility(View.VISIBLE);
                    }
                    else if (u4Form138 == true && u4Form137 == true && u4PSA == true && u4HonDis == true && u4Transcript == true &&
                            u4Accounting.equals("No Balance") && u4Library.equals("All Books Returned") == true &&
                            u4IndInv == true && u4CareerPlan == true && u4Consent == true &&
                            u4Discipline == true && u4ComLab == true  && u4Lab == true && u4Alumni == true) {
                        schoolPersonel_u4LNRLYT.setVisibility(View.VISIBLE);
                    }
                    else if (u5Form138 == true && u5Form137 == true && u5PSA == true && u5HonDis == true && u5Transcript == true &&
                            u5Accounting.equals("No Balance") && u5Library.equals("All Books Returned") == true &&
                            u5IndInv == true && u5CareerPlan == true && u5Consent == true &&
                            u5Discipline == true && u5ComLab == true  && u5Lab == true && u5Alumni == true) {
                        schoolPersonel_u5LNRLYT.setVisibility(View.VISIBLE);
                    }
                }
                else if (searchData.equals("#inc")) {
                    schoolPersonel_u1LNRLYT.setVisibility(View.VISIBLE);
                    schoolPersonel_u2LNRLYT.setVisibility(View.VISIBLE);
                    schoolPersonel_u3LNRLYT.setVisibility(View.VISIBLE);
                    schoolPersonel_u4LNRLYT.setVisibility(View.VISIBLE);
                    schoolPersonel_u5LNRLYT.setVisibility(View.VISIBLE);

                    if (u1Form138 == true && u1Form137 == true && u1PSA == true && u1HonDis == true && u1Transcript == true &&
                            u1Accounting.equals("No Balance") && u1Library.equals("All Books Returned") == true &&
                            u1IndInv == true && u1CareerPlan == true && u1Consent == true &&
                            u1Discipline == true && u1ComLab == true  && u1Lab == true && u1Alumni == true) {
                        schoolPersonel_u1LNRLYT.setVisibility(View.GONE);
                    }
                    else if (u2Form138 == true && u2Form137 == true && u2PSA == true && u2HonDis == true && u2Transcript == true &&
                            u2Accounting.equals("No Balance") && u2Library.equals("All Books Returned") == true &&
                            u2IndInv == true && u2CareerPlan == true && u2Consent == true &&
                            u2Discipline == true && u2ComLab == true  && u2Lab == true && u2Alumni == true) {
                        schoolPersonel_u2LNRLYT.setVisibility(View.GONE);
                    }
                    else if (u3Form138 == true && u3Form137 == true && u3PSA == true && u3HonDis == true && u3Transcript == true &&
                            u3Accounting.equals("No Balance") && u3Library.equals("All Books Returned") == true &&
                            u3IndInv == true && u3CareerPlan == true && u3Consent == true &&
                            u3Discipline == true && u3ComLab == true  && u3Lab == true && u3Alumni == true) {
                        schoolPersonel_u3LNRLYT.setVisibility(View.GONE);
                    }
                    else if (u4Form138 == true && u4Form137 == true && u4PSA == true && u4HonDis == true && u4Transcript == true &&
                            u4Accounting.equals("No Balance") && u4Library.equals("All Books Returned") == true &&
                            u4IndInv == true && u4CareerPlan == true && u4Consent == true &&
                            u4Discipline == true && u4ComLab == true  && u4Lab == true && u4Alumni == true) {
                        schoolPersonel_u4LNRLYT.setVisibility(View.GONE);
                    }
                    else if (u5Form138 == true && u5Form137 == true && u5PSA == true && u5HonDis == true && u5Transcript == true &&
                            u5Accounting.equals("No Balance") && u5Library.equals("All Books Returned") == true &&
                            u5IndInv == true && u5CareerPlan == true && u5Consent == true &&
                            u5Discipline == true && u5ComLab == true  && u5Lab == true && u5Alumni == true) {
                        schoolPersonel_u5LNRLYT.setVisibility(View.GONE);
                    }
                }
                else if (searchData.length() != 0) {
                    schoolPersonel_u1LNRLYT.setVisibility(View.GONE);
                    schoolPersonel_u2LNRLYT.setVisibility(View.GONE);
                    schoolPersonel_u3LNRLYT.setVisibility(View.GONE);
                    schoolPersonel_u4LNRLYT.setVisibility(View.GONE);
                    schoolPersonel_u5LNRLYT.setVisibility(View.GONE);
                    if ((u1FName + " " + u1Lname).toLowerCase().contains(searchData.toLowerCase())) {
                        schoolPersonel_u1LNRLYT.setVisibility(View.VISIBLE);
                    }
                    if ((u2FName + " " + u2Lname).toLowerCase().contains(searchData.toLowerCase())) {
                        schoolPersonel_u2LNRLYT.setVisibility(View.VISIBLE);
                    }
                    if ((u3FName + " " + u3Lname).toLowerCase().contains(searchData.toLowerCase())) {
                        schoolPersonel_u3LNRLYT.setVisibility(View.VISIBLE);
                    }
                    if ((u4FName + " " + u4Lname).toLowerCase().contains(searchData.toLowerCase())) {
                        schoolPersonel_u4LNRLYT.setVisibility(View.VISIBLE);
                    }
                    if ((u5FName + " " + u5Lname).toLowerCase().contains(searchData.toLowerCase())) {
                        schoolPersonel_u5LNRLYT.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    private void chooseUpdate(final int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Update")
                .setItems(R.array.update_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        which = which+1;
                        if (which == 1) {
                            updateDialog(i, which);
                        }
                        else if (which == 2) {
                            updateDialog(i, which);
                        }
                        else if (which == 3) {
                            updateDialog(i, which);
                        }
                        else if (which == 4) {
                            updateDialog(i, which);
                        }
                        else if (which == 5) {
                            updateDialog(i, which);
                        }
                    }
                });
        builder.create();
        builder.show();
    }

    private void updateDialog(final int user, final int updatePos) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Update")
                .setItems(R.array.update_options_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        which = which+1;
                        if (which == 1) {
                            boolean newValUp = true;
                            //Copy Start
                            if (user == 1) {
                                if (updatePos == 1) {
                                    if (u1State.equals("freshmen")) {
                                        u1Form137 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 2) {
                                    if (u1State.equals("freshmen")) {
                                        u1Form138 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 3) {
                                    u1PSA = newValUp;
                                    Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                }
                                else if (updatePos == 4) {
                                    if (u1State.equals("transferee")) {
                                        u1HonDis = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 5) {
                                    if (u1State.equals("transferee")) {
                                        u1Transcript = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            if (user == 2) {
                                if (updatePos == 1) {
                                    if (u2State.equals("freshmen")) {
                                        u2Form137 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 2) {
                                    if (u2State.equals("freshmen")) {
                                        u2Form138 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 3) {
                                    u2PSA = newValUp;
                                    Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                }
                                else if (updatePos == 4) {
                                    if (u2State.equals("transferee")) {
                                        u2HonDis = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 5) {
                                    if (u2State.equals("transferee")) {
                                        u2Transcript = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            if (user == 3) {
                                if (updatePos == 1) {
                                    if (u3State.equals("freshmen")) {
                                        u3Form137 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 2) {
                                    if (u3State.equals("freshmen")) {
                                        u3Form138 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 3) {
                                    u3PSA = newValUp;
                                    Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                }
                                else if (updatePos == 4) {
                                    if (u3State.equals("transferee")) {
                                        u3HonDis = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 5) {
                                    if (u3State.equals("transferee")) {
                                        u3Transcript = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            if (user == 4) {
                                if (updatePos == 1) {
                                    if (u4State.equals("freshmen")) {
                                        u4Form137 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 2) {
                                    if (u4State.equals("freshmen")) {
                                        u4Form138 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 3) {
                                    u4PSA = newValUp;
                                    Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                }
                                else if (updatePos == 4) {
                                    if (u4State.equals("transferee")) {
                                        u4HonDis = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 5) {
                                    if (u4State.equals("transferee")) {
                                        u4Transcript = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            if (user == 5) {
                                if (updatePos == 1) {
                                    if (u5State.equals("freshmen")) {
                                        u5Form137 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 2) {
                                    if (u5State.equals("freshmen")) {
                                        u5Form138 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 3) {
                                    u5PSA = newValUp;
                                    Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                }
                                else if (updatePos == 4) {
                                    if (u5State.equals("transferee")) {
                                        u5HonDis = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 5) {
                                    if (u5State.equals("transferee")) {
                                        u5Transcript = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            //Copy End
                        }
                        else if (which == 2) {
                            boolean newValUp = false;
                            //Kinapy Start
                            if (user == 1) {
                                if (updatePos == 1) {
                                    if (u1State.equals("freshmen")) {
                                        u1Form137 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 2) {
                                    if (u1State.equals("freshmen")) {
                                        u1Form138 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 3) {
                                    u1PSA = newValUp;
                                    Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                }
                                else if (updatePos == 4) {
                                    if (u1State.equals("transferee")) {
                                        u1HonDis = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 5) {
                                    if (u1State.equals("transferee")) {
                                        u1Transcript = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            if (user == 2) {
                                if (updatePos == 1) {
                                    if (u2State.equals("freshmen")) {
                                        u2Form137 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 2) {
                                    if (u2State.equals("freshmen")) {
                                        u2Form138 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 3) {
                                    u2PSA = newValUp;
                                    Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                }
                                else if (updatePos == 4) {
                                    if (u2State.equals("transferee")) {
                                        u2HonDis = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 5) {
                                    if (u2State.equals("transferee")) {
                                        u2Transcript = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            if (user == 3) {
                                if (updatePos == 1) {
                                    if (u3State.equals("freshmen")) {
                                        u3Form137 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 2) {
                                    if (u3State.equals("freshmen")) {
                                        u3Form138 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 3) {
                                    u3PSA = newValUp;
                                    Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                }
                                else if (updatePos == 4) {
                                    if (u3State.equals("transferee")) {
                                        u3HonDis = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 5) {
                                    if (u3State.equals("transferee")) {
                                        u3Transcript = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            if (user == 4) {
                                if (updatePos == 1) {
                                    if (u4State.equals("freshmen")) {
                                        u4Form137 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 2) {
                                    if (u4State.equals("freshmen")) {
                                        u4Form138 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 3) {
                                    u4PSA = newValUp;
                                    Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                }
                                else if (updatePos == 4) {
                                    if (u4State.equals("transferee")) {
                                        u4HonDis = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 5) {
                                    if (u4State.equals("transferee")) {
                                        u4Transcript = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            if (user == 5) {
                                if (updatePos == 1) {
                                    if (u5State.equals("freshmen")) {
                                        u5Form137 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 2) {
                                    if (u5State.equals("freshmen")) {
                                        u5Form138 = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a transferee.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 3) {
                                    u5PSA = newValUp;
                                    Toast.makeText(AppActivity.this, "Marked as not not yet submitted!", Toast.LENGTH_SHORT).show();
                                }
                                else if (updatePos == 4) {
                                    if (u5State.equals("transferee")) {
                                        u5HonDis = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if (updatePos == 5) {
                                    if (u5State.equals("transferee")) {
                                        u5Transcript = newValUp;
                                        Toast.makeText(AppActivity.this, "Marked as not submitted!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(AppActivity.this, "Data not updated! Student is a freshmen.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            //Kinapy End
                        }
                    }
                });
        builder.create();
        builder.show();
    }

    private void checkPassChanged() {
        if (u1changed.equals("false") && activeUser == 1) {
            changePass();
        }
        else if (u2changed.equals("false") && activeUser == 2) {
            changePass();
        }
        else if (u3changed.equals("false") && activeUser == 3) {
            changePass();
        }
        else if (u4changed.equals("false") && activeUser == 4) {
            changePass();
        }
        else if (u5changed.equals("false") && activeUser == 5) {
            changePass();
        }
        else {
            mainUserActivity();
        }
    }

    private void mainUserActivity() {
        activeAct = "mainUser";
        setContentView(R.layout.layout_main_user);
        backCount = 0;
        mainUser_LogOutBTTN = (Button)findViewById(R.id.mainUser_LogOutBTTN);
        mainUserLastNameTXTVW = (TextView)findViewById(R.id.mainUserLastNameTXTVW);
        mainUserFirstNameTXTVW = (TextView)findViewById(R.id.mainUserFirstNameTXTVW);
        mainUser_RegistrarLNRLYT = (LinearLayout)findViewById(R.id.mainUser_RegistrarLNRLYT);
        mainUser_libraryLNRLYT = (LinearLayout)findViewById(R.id.mainUser_libraryLNRLYT);
        mainUser_AccountingLNRLYT = (LinearLayout)findViewById(R.id.mainUser_AccountingLNRLYT);
        mainUser_GuidanceLNRLYT = (LinearLayout)findViewById(R.id.mainUser_GuidanceLNRLYT);
        mainUser_MoreLNRLYT = (LinearLayout)findViewById(R.id.mainUser_MoreLNRLYT);
        mainUser_LogOutBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeUser = -1;
                logInActivity();
            }
        });

        mainUser_RegistrarLNRLYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpFreshMen();
            }
        });
        mainUser_libraryLNRLYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpLibrary();
            }
        });
        mainUser_GuidanceLNRLYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpGuidance();
            }
        });
        mainUser_AccountingLNRLYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpAccounting();
            }
        });
        mainUser_MoreLNRLYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpMore();
            }
        });

        if (activeUser ==1) {
            mainUserLastNameTXTVW.setText(u1Lname);
            mainUserFirstNameTXTVW.setText(u1FName);
        }
        else if (activeUser ==2) {
            mainUserLastNameTXTVW.setText(u2Lname);
            mainUserFirstNameTXTVW.setText(u2FName);
        }
        else if (activeUser ==3) {
            mainUserLastNameTXTVW.setText(u3Lname);
            mainUserFirstNameTXTVW.setText(u3FName);
        }
        else if (activeUser ==4) {
            mainUserLastNameTXTVW.setText(u4Lname);
            mainUserFirstNameTXTVW.setText(u4FName);
        }
        else if (activeUser ==5) {
            mainUserLastNameTXTVW.setText(u5Lname);
            mainUserFirstNameTXTVW.setText(u5FName);
        }
    }

    private void changePass() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.dialog_pass, null);
        builder.setView(dialogView)
                .setPositiveButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialogPass_newPassDTTXT = (EditText)dialogView.findViewById(R.id.dialogPass_newPassDTTXT);
                        String newPass = dialogPass_newPassDTTXT.getText().toString();
                        if (newPass.length() != 0) {
                            if (newPass.length() < 8) {
                                Toast.makeText(AppActivity.this, "Password must be atleast 8 characters!", Toast.LENGTH_SHORT).show();
                            }
                            else if (newPass.equals("12345678")) {
                                Toast.makeText(AppActivity.this, "Don't use default password!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                if (activeUser == 1) {
                                    u1Password = newPass;
                                    u1changed = "true";
                                    mainUserActivity();
                                    Toast.makeText(AppActivity.this, "Password Changed!", Toast.LENGTH_SHORT).show();
                                }
                                else if (activeUser == 2) {
                                    u2Password = newPass;
                                    u2changed = "true";
                                    mainUserActivity();
                                    Toast.makeText(AppActivity.this, "Password Changed!", Toast.LENGTH_SHORT).show();
                                }
                                else if (activeUser == 3) {
                                    u3Password = newPass;
                                    u3changed = "true";
                                    mainUserActivity();
                                    Toast.makeText(AppActivity.this, "Password Changed!", Toast.LENGTH_SHORT).show();
                                }
                                else if (activeUser == 4) {
                                    u4Password = newPass;
                                    u4changed = "true";
                                    mainUserActivity();
                                    Toast.makeText(AppActivity.this, "Password Changed!", Toast.LENGTH_SHORT).show();
                                }
                                else if (activeUser == 5) {
                                    u5Password = newPass;
                                    u5changed = "true";
                                    mainUserActivity();
                                    Toast.makeText(AppActivity.this, "Password Changed!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        else {
                            Toast.makeText(AppActivity.this, "Password not changed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Toast.makeText(AppActivity.this, "Password not changed!", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create();
        builder.show();
    }

    @Override
    public void onBackPressed() {
        if (activeAct.equals("login")) {
            if (backCount == 2) {
                super.onBackPressed();
            }
            else if (backCount == 1) {
                Toast.makeText(this, "Press again to exit!", Toast.LENGTH_SHORT).show();
                backCount++;
            }
            else if (backCount == 0) {
                Toast.makeText(this, "Press again 2x to exit!", Toast.LENGTH_SHORT).show();
                backCount++;
            }
            else {
                backCount++;
            }
        }
        else {

        }
    }
}
