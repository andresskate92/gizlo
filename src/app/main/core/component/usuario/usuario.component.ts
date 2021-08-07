import { Component, OnInit } from '@angular/core';
import { TipoUsuario } from '../../modelGlobal/tipoUsuario';
import { UsuarioModel } from '../../modelGlobal/usuarioModel';
import { UsuarioService } from './usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.scss']
})
export class UsuarioComponent implements OnInit {

  public tipUsuarioSelect: string = "";
  public listTipoUsuario: TipoUsuario[] = [{ codTipoUsuario: 'UE', usuario: 'Usuario Externo' }, { codTipoUsuario: 'UI', usuario: 'Usuario Interno' }];
  public listUsuarios: UsuarioModel[] = [];

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
  }

  public listaTipoUsuario(): void {
    this.usuarioService.getListaUsuarioExterno('', this.tipUsuarioSelect).subscribe(response => {
      if (response) {
        if (response.clave === 'true') {

          console.log(response);
          response.valor.forEach(x => {
            const objUsuario: UsuarioModel = {
              estado: x.estado,
              fechaRegistro: x.fechaRegistro,
              tipoUsuario: x.tipoUsuario,
              usuario: x.usuario
            }
            this.listUsuarios.push(objUsuario);
          });


          console.log
        }
      } else {
        alert('No se encontraron datos');
      }
    }, error => {
      let errorMensaje = error.message;
      alert('Error ' + errorMensaje);
    });
  }


}
