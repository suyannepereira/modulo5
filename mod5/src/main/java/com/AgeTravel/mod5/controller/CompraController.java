package com.AgeTravel.mod5.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.AgeTravel.mod5.model.Cliente;
import com.AgeTravel.mod5.model.Compra;
import com.AgeTravel.mod5.model.Destino;
import com.AgeTravel.mod5.repository.ClienteRepository;
import com.AgeTravel.mod5.repository.CompraRepository;
import com.AgeTravel.mod5.repository.DestinoRepository;

@Controller
@RequestMapping("/compras")
public class CompraController {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private DestinoRepository destinoRepository;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("compras/index.html");

		List<Compra> compras = compraRepository.findAll();
		List<Cliente> clientes = clienteRepository.findAll();
		List<Destino> destinos = destinoRepository.findAll();
		modelAndView.addObject("compras", compras);

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("compras/cadastro");

		modelAndView.addObject("compra", new Compra());
		modelAndView.addObject("cliente", clienteRepository.findAll());
		modelAndView.addObject("destino", destinoRepository.findAll());


		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Compra compra) throws IOException {

		compraRepository.save(compra);
		ModelAndView modelAndView = new ModelAndView("redirect:/compras");

		
		return modelAndView;
	}
	
	
	@GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("compras/atualizar");

        modelAndView.addObject(compraRepository.getReferenceById(id));
        modelAndView.addObject("cliente", clienteRepository.findAll());
		modelAndView.addObject("destino", destinoRepository.findAll());
        

        return modelAndView;
    }
	
	@PostMapping("/{id}/editar")
    public ModelAndView editar(Compra compra)  {


		compraRepository.save(compra);
        ModelAndView modelAndView = new ModelAndView("redirect:/compras");

        return modelAndView;
    }

	 @GetMapping("/{id}/excluir")
	    public ModelAndView excluir(@PathVariable Long id) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/compras");

	        compraRepository.deleteById(id);

	        return modelAndView;
	    }
	
}
