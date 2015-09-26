package com.example.administrator.carstereo;

import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, View.OnLongClickListener {

    ToggleButton Power;
    TextView RadioDisplay;
    TextView RadioStation;
    Button Save_1;
    Button Save_2;
    Button Save_3;
    Button Save_4;
    Button Save_5;
    Button Save_6;
    Button AMFM;
    boolean i = true;
    boolean amfm = true;
    boolean power = false;
    double fm = 88.1;
    int am = 530;
    Button SeekForward;
    Button SeekBack;
    int pre1 = 550;
    int pre2 = 600;
    int pre3 = 650;
    int pre4 = 700;
    int pre5 = 750;
    int pre6 = 800;

    double pre1fm = 90.9;
    double pre2fm = 92.9;
    double pre3fm = 94.9;
    double pre4fm = 96.9;
    double pre5fm = 98.9;
    double pre6fm = 100.9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Power = (ToggleButton) findViewById(R.id.Power);
        RadioDisplay = (TextView) findViewById(R.id.RadioDisplay);
        RadioStation = (TextView) findViewById(R.id.RadioStation);
        Save_1 = (Button) findViewById(R.id.Save_1);
        Save_2 = (Button) findViewById(R.id.Save_2);
        Save_3 = (Button) findViewById(R.id.Save_3);
        Save_4 = (Button) findViewById(R.id.Save_4);
        Save_5 = (Button) findViewById(R.id.Save_5);
        Save_6 = (Button) findViewById(R.id.Save_6);
        AMFM = (Button) findViewById(R.id.AMFM);
        SeekBack = (Button) findViewById(R.id.SeekBack);
        SeekForward = (Button) findViewById(R.id.SeekForward);

        Power.setOnClickListener(this);
        AMFM.setOnClickListener(this);
        SeekBack.setOnClickListener(this);
        SeekForward.setOnClickListener(this);
        Save_1.setOnClickListener(this);
        Save_2.setOnClickListener(this);
        Save_3.setOnClickListener(this);
        Save_4.setOnClickListener(this);
        Save_5.setOnClickListener(this);
        Save_6.setOnClickListener(this);

        Save_1.setOnLongClickListener(this);
        Save_2.setOnLongClickListener(this);
        Save_3.setOnLongClickListener(this);
        Save_4.setOnLongClickListener(this);
        Save_5.setOnLongClickListener(this);
        Save_6.setOnLongClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.AMFM) {
            if (amfm == true) {
                amfm = false;
            } else {
                amfm = true;
            }
        }

        if (v.getId() == R.id.Power) {
            if (i == true) {
                power = true;
                Power.setChecked(true);
                Save_1.setEnabled(true);
                Save_2.setEnabled(true);
                Save_3.setEnabled(true);
                Save_4.setEnabled(true);
                Save_5.setEnabled(true);
                Save_6.setEnabled(true);
                AMFM.setEnabled(true);

                RadioStation.setVisibility(View.VISIBLE);
                RadioDisplay.setVisibility(View.VISIBLE);
                i = false;
            } else {

                power = false;
                Power.setChecked(false);
                Save_1.setEnabled(false);
                Save_2.setEnabled(false);
                Save_3.setEnabled(false);
                Save_4.setEnabled(false);
                Save_5.setEnabled(false);
                Save_6.setEnabled(false);
                RadioStation.setVisibility(View.GONE);
                RadioDisplay.setVisibility(View.GONE);
                i = true;
                AMFM.setEnabled(false);
            }

        }

        if (v.getId() == R.id.SeekForward) {
            if (power == true) {
                if (amfm == true) {
                    fm = fm + 0.2;
                    fm = (int) (fm * 10.0);
                    fm = fm / 10.0;

                    if (fm > 88.1) {
                        if (fm > 107.9) {
                            fm = 88.1;
                        }
                        RadioStation.setText(fm + "FM");
                    }
                } else {
                    am = am + 10;

                    if (am > 530) {
                        if (am > 1700) {
                            am = 530;
                        }
                        RadioStation.setText(am + "AM");
                    }
                }
            }
        }

        if (v.getId() == R.id.SeekBack) {
            if (power == true) {
                if (amfm == true) {
                    fm = fm - 0.2;
                    fm = (int) (fm * 10.0);
                    fm = fm / 10.0;

                    if (fm < 107.9) {
                        if (fm < 88.1) {
                            fm = 107.9;
                        }
                        RadioStation.setText(fm + "FM");
                    }
                } else {
                    am = am - 10;

                    if (am < 1700) {
                        if (am < 530) {
                            am = 1700;
                        }
                        RadioStation.setText(am + "AM");
                    }
                }
            }
        }

        if (v.getId() == R.id.Save_1) {
            if (power == true) {
                if (amfm == false) {
                    am = pre1;
                    RadioStation.setText(pre1 + "AM");
                } else {
                    fm = pre1fm;
                    RadioStation.setText(pre1fm + "FM");
                }
            }

        }
        if (v.getId() == R.id.Save_2) {
            if (power == true) {
                if (amfm == false) {
                    am = pre2;
                    RadioStation.setText(pre2 + "AM");
                } else {
                    fm = pre2fm;
                    RadioStation.setText(pre2fm + "FM");
                }
            }

        }

        if (v.getId() == R.id.Save_3) {
            if (power == true) {
                if (amfm == false) {
                    am = pre3;
                    RadioStation.setText(pre3 + "AM");
                } else {
                    fm = pre3fm;
                    RadioStation.setText(pre3fm + "FM");
                }
            }

        }

        if (v.getId() == R.id.Save_4) {
            if (power == true) {
                if (amfm == false) {
                    am = pre4;
                    RadioStation.setText(pre4 + "AM");
                } else {
                    fm = pre4fm;
                    RadioStation.setText(pre4fm + "FM");
                }
            }

        }

        if (v.getId() == R.id.Save_5) {
            if (power == true) {
                if (amfm == false) {
                    am = pre5;
                    RadioStation.setText(pre5 + "AM");
                } else {
                    fm = pre5fm;
                    RadioStation.setText(pre5fm + "FM");
                }
            }

        }

        if (v.getId() == R.id.Save_6) {
            if (power == true) {
                if (amfm == false) {
                    am = pre6;
                    RadioStation.setText(pre6 + "AM");
                } else {
                    fm = pre6fm;
                    RadioStation.setText(pre6fm + "FM");
                }
            }

        }
    }

    public boolean onLongClick(View v) {

        if (v.getId() == R.id.Save_1) {
            if (power == true) {
                if (amfm == false) {
                    pre1 = am;
                    RadioStation.setText(pre1 + "AM");
                    return true;
                } else {
                    pre1fm = fm;
                    RadioStation.setText(pre1fm + "FM");
                    return true;
                }
            }

        }

        if (v.getId() == R.id.Save_2) {
            if (power == true) {
                if (amfm == false) {
                    pre2 = am;
                    RadioStation.setText(pre2 + "AM");
                    return true;
                } else {
                    pre2fm = fm;
                    RadioStation.setText(pre2fm + "FM");
                    return true;
                }
            }
        }

        if (v.getId() == R.id.Save_3) {
            if (power == true) {
                if (amfm == false) {
                    pre3 = am;
                    RadioStation.setText(pre3 + "AM");
                    return true;
                } else {
                    pre3fm = fm;
                    RadioStation.setText(pre3fm + "FM");
                    return true;
                }
            }
        }
        if (v.getId() == R.id.Save_4) {
            if (power == true) {
                if (amfm == false) {
                    pre4 = am;
                    RadioStation.setText(pre4 + "AM");
                    return true;
                } else {
                    pre4fm = fm;
                    RadioStation.setText(pre4fm + "FM");
                    return true;
                }
            }
        }
        if (v.getId() == R.id.Save_5) {
            if (power == true) {
                if (amfm == false) {
                    pre5 = am;
                    RadioStation.setText(pre5 + "AM");
                    return true;
                } else {
                    pre5fm = fm;
                    RadioStation.setText(pre5fm + "FM");
                    return true;
                }
            }
        }
        if (v.getId() == R.id.Save_6) {
            if (power == true) {
                if (amfm == false) {
                    pre6 = am;
                    RadioStation.setText(pre6 + "AM");
                    return true;
                } else {
                    pre6fm = fm;
                    RadioStation.setText(pre6fm + "FM");
                    return true;
                }
            }
        }
        return false;
    }
}





