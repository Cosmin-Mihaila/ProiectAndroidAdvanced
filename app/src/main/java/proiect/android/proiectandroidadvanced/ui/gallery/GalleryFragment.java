package proiect.android.proiectandroidadvanced.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import proiect.android.proiectandroidadvanced.Contact;
import proiect.android.proiectandroidadvanced.ContactsAdapter;
import proiect.android.proiectandroidadvanced.R;

public class GalleryFragment extends Fragment {
    ArrayList<Contact> contacts = new ArrayList<>();

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));
        RecyclerView rvContacts = (RecyclerView) root.findViewById(R.id.rvContacts);


        contacts = Contact.createContactsList(50);
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }
}