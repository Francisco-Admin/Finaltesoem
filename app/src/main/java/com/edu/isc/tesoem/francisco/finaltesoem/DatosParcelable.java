package com.edu.isc.tesoem.francisco.finaltesoem;

import android.os.Parcel;
import android.os.Parcelable;

public class DatosParcelable implements Parcelable {
    String nombre, matricula, correo, promediofinal;

    public DatosParcelable(String nombre, String matricula, String correo, String promediofinal) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.correo = correo;
        this.promediofinal = promediofinal;
    }

    protected DatosParcelable(Parcel in) {
        nombre = in.readString();
        matricula = in.readString();
        correo = in.readString();
        promediofinal = in.readString();
    }

    public static final Creator<DatosParcelable> CREATOR = new Creator<DatosParcelable>() {
        @Override
        public DatosParcelable createFromParcel(Parcel in) {
            return new DatosParcelable(in);
        }

        @Override
        public DatosParcelable[] newArray(int size) {
            return new DatosParcelable[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPromediofinal() {
        return promediofinal;
    }

    public void setPromediofinal(String promediofinal) {
        this.promediofinal = promediofinal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(matricula);
        dest.writeString(correo);
        dest.writeString(promediofinal);
    }
}
