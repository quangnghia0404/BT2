package vn.edu.ntu.quangnghia.bt2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quangnghia.controller.ContactController;
import vn.edu.ntu.quangnghia.controller.IContactController;
import vn.edu.ntu.quangnghia.model.Contact;


public class ListContactFragment extends Fragment {

    IContactController controller;
    List<Contact> listContacts = new ArrayList<>();
    RecyclerView rvListContact;
    ContactAdapter adapter;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_contact, container, false);
        addViews(view);
        return view;
    }

    private void addViews(View view) {
        controller = new ContactController();
        listContacts = controller.getAllContact();
        adapter = new ContactAdapter(listContacts);
        rvListContact = view.findViewById(R.id.rvListContact);
        rvListContact.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvListContact.setAdapter(adapter);
        navController = NavHostFragment.findNavController(ListContactFragment.this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.mnu_add,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.itemAdd: ShowContact();
        }

        return super.onOptionsItemSelected(item);
    }

    private void ShowContact() {
        Bundle bundle = new Bundle();
        bundle.putInt("Id",-1);
        navController.navigate(R.id.action_listContactFragment_to_editContactFragment,bundle);

    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtDateOfBirth, txtPhoneNumber;
        ImageView imvEdit, imvPhone, imvMessage;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtDateOfBirth = itemView.findViewById(R.id.txtDateOfBirth);
            txtPhoneNumber = itemView.findViewById(R.id.txtPhoneNumber);
            imvEdit = itemView.findViewById(R.id.imvEdit);
            imvPhone = itemView.findViewById(R.id.imvPhone);
            imvMessage = itemView.findViewById(R.id.imvMessage);
        }

        public void bind(Contact contact){
            txtName.setText(contact.getName());
            txtDateOfBirth.setText(contact.getDateOfBirth());
            txtPhoneNumber.setText(contact.getPhoneNumber());
        }
    }

    public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder>{

        List<Contact> listContacts = new ArrayList<>();

        public ContactAdapter(List<Contact> listContacts) {
            this.listContacts = listContacts;
        }

        @NonNull
        @Override
        public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.contact_layout,parent,false);
            return new ContactViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactViewHolder holder, final int position) {
            holder.bind(listContacts.get(position));
            holder.imvEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("Id",position);
                    navController.navigate(R.id.action_listContactFragment_to_editContactFragment,bundle);
                }
            });
        }

        @Override
        public int getItemCount() {
            return listContacts.size();
        }
    }
}