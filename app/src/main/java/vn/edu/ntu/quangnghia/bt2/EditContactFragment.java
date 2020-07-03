package vn.edu.ntu.quangnghia.bt2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quangnghia.controller.ContactController;
import vn.edu.ntu.quangnghia.controller.IContactController;
import vn.edu.ntu.quangnghia.model.Contact;


public class EditContactFragment extends Fragment {

    EditText edtID, edtName, edtDateOfBirth, edtPhoneNumber, edtAddress;
    Button btnLuu;
    List<Contact> listContacts = new ArrayList<>();
    IContactController controller;
    int id;
   
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       
       View view = inflater.inflate(R.layout.fragment_edit_contact, container, false);
       addViews(view);
       addActions();
                    return view;
                }

                private void addActions() {
                    btnLuu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (id == -1){
                                Contact contact = new Contact();
                                contact.setId(Integer.parseInt(edtID.getText().toString()));
                                contact.setName(edtName.getText().toString());
                    contact.setDateOfBirth(edtDateOfBirth.getText().toString());
                    contact.setAddress(edtAddress.getText().toString());
                    contact.setPhoneNumber(edtPhoneNumber.getText().toString());
                    controller.addContact(contact);
                    Toast.makeText(getActivity(),"Thêm thành công",Toast.LENGTH_LONG).show();
                }
                else{
                    Contact contact = new Contact();
                    contact.setId(Integer.parseInt(edtID.getText().toString()));
                    contact.setName(edtName.getText().toString());
                    contact.setDateOfBirth(edtDateOfBirth.getText().toString());
                    contact.setAddress(edtAddress.getText().toString());
                    contact.setPhoneNumber(edtPhoneNumber.getText().toString());
                    controller.updateContact(contact);
                    Toast.makeText(getActivity(),"Sửa thành công",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void addViews(View view) {
        edtID = view.findViewById(R.id.edtID);
        edtName = view.findViewById(R.id.edtName);
        edtDateOfBirth = view.findViewById(R.id.edtDateOfBirth);
        edtPhoneNumber = view.findViewById(R.id.edtPhoneNumber);
        edtAddress = view.findViewById(R.id.edtAddress);
        btnLuu = view.findViewById(R.id.btnLuu);
        controller = new ContactController();
        listContacts = controller.getAllContact();
        Bundle bundle = getArguments();
        int id = bundle.getInt("Id");

        if(id != -1){
            btnLuu.setText("Sửa");
            Contact contact = listContacts.get(id);
            edtID.setText(Integer.toString(contact.getId()) );
            edtName.setText(contact.getName());
            edtDateOfBirth.setText(contact.getDateOfBirth());
            edtPhoneNumber.setText(contact.getPhoneNumber());
            edtAddress.setText(contact.getAddress());
        }

        else{
            btnLuu.setText("Thêm");
            int max = listContacts.get(listContacts.size() - 1).getId() + 1;
            edtID.setText(Integer.toString(max));
        }


    }
}