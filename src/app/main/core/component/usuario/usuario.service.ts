import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClaveValor } from '../../modelGlobal/claveValor';
import { UsuarioModel } from '../../modelGlobal/usuarioModel';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  public getListaUsuarioExterno(usuario: string, tipoUsuario: string): Observable<ClaveValor> {
    return this.http.get<ClaveValor>('http://localhost:9001/appGizlo/usuarioMS/consulta-usuario?usuario=' + usuario + '&tipoUsuario=' + tipoUsuario);
  }
}
